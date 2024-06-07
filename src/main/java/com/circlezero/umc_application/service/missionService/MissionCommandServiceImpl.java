package com.circlezero.umc_application.service.missionService;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.apiPayload.exception.handler.StoreHandler;
import com.circlezero.umc_application.converter.MissionConverter;
import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.repository.MissionRepository;
import com.circlezero.umc_application.service.memberService.MemberQueryService;
import com.circlezero.umc_application.service.storeService.StoreQueryService;
import com.circlezero.umc_application.web.dto.missionDTO.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final MemberQueryService memberQueryService;
    private final StoreQueryService storeQueryService;

    @Override
    public Mission createMission(MissionRequestDTO.CreateDto request) {
        Mission mission = MissionConverter.toMission(
                request,
                storeQueryService.findStore(request.getStoreId()).orElseThrow(
                        () ->
                                new StoreHandler(
                                        ErrorStatus.STORE_NOT_FOUND
                                )
                )
        );
        return missionRepository.save(mission);
    }

    @Override
    public boolean isValidMission(Long id) {
        return missionRepository.existsById(id);
    }

    @Override
    public boolean isExpiredMission(Mission mission){
        return mission.getDeadline().isBefore(LocalDate.now());
    }

    @Override
    public boolean isStartedMission(Member member, Mission mission){
        return member.getMemberMissionList().stream().anyMatch(mtm -> mtm.getMission().equals(mission));
    }
}
