package com.circlezero.umc_application.web.controller;


import com.circlezero.umc_application.apiPayload.ApiResponse;
import com.circlezero.umc_application.converter.MemberConverter;
import com.circlezero.umc_application.converter.MemberToMissionConverter;
import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.mapping.MemberToMission;
import com.circlezero.umc_application.service.memberService.MemberCommandService;
import com.circlezero.umc_application.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.umc_application.web.dto.memberDTO.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/start_mission")
    public ApiResponse<MemberResponseDTO.StartMissionResultDTO> startMission(
            @RequestBody @Valid MemberRequestDTO.StartMissionDTO request
    ){
        MemberToMission memberToMission = memberCommandService.startMission(request);
        return ApiResponse.onSuccess(MemberToMissionConverter.toStartMissionResult(memberToMission));
    }
}
