package com.circlezero.umc_application.service.memberService;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.apiPayload.exception.handler.FoodCategoryHandler;
import com.circlezero.umc_application.apiPayload.exception.handler.MemberHandler;
import com.circlezero.umc_application.apiPayload.exception.handler.MissionHandler;
import com.circlezero.umc_application.converter.MemberConverter;
import com.circlezero.umc_application.converter.MemberPreferConverter;
import com.circlezero.umc_application.converter.MemberToMissionConverter;
import com.circlezero.umc_application.domain.FoodCategory;
import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.domain.enums.MemberStatus;
import com.circlezero.umc_application.domain.enums.MissionStatus;
import com.circlezero.umc_application.domain.mapping.MemberPrefer;
import com.circlezero.umc_application.domain.mapping.MemberToMission;
import com.circlezero.umc_application.repository.FoodCategoryRepository;
import com.circlezero.umc_application.repository.MemberRepository;
import com.circlezero.umc_application.repository.MissionRepository;
import com.circlezero.umc_application.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.umc_application.web.dto.memberDTO.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        // request에서 유저가 선택한 선호 음식 Long 값들을 FoodCategory로 변경
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream().map(
                category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() ->
                                    new FoodCategoryHandler(
                                            ErrorStatus.FOOD_CATEGORY_NOT_FOUND
                                    )
                            );
                }
        ).toList();
        // FoodCategory 들을 바탕으로 member 세팅은 되어있지 않은 MemberPrefer 리스트로 변환
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        // MemberPrefer 들 각각에 누가 선택했는지 member 를 세팅
        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(member);
        });

        return memberRepository.save(member);
    }

    @Override
    public boolean isValidMember(Long id) {
        Optional<Member> memberOpt = memberRepository.findById(id);
        if(memberOpt.isEmpty()) return false;
        Member member = memberOpt.get();
        return !member.getStatus().equals(MemberStatus.INACTIVE);
    }

    @Override
    public MemberToMission startMission(MemberRequestDTO.StartMissionDTO request) {
        Optional<Member> memberOpt = memberRepository.findById(request.getMemberId());
        Optional<Mission> missionOpt = missionRepository.findById(request.getMissionId());
        if(memberOpt.isEmpty()){
            throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        }
        if(missionOpt.isEmpty()){
            throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);
        }
        Member member = memberOpt.get();
        Mission mission = missionOpt.get();

        if(mission.getDeadline().isBefore(LocalDate.now())){
            throw new MissionHandler(ErrorStatus.MISSION_EXPIRED);
        }
        MemberToMission memberToMission = MemberToMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
        memberToMission.setMemberMission(member, mission);
        memberRepository.save(member);
        return memberToMission;
    }
}
