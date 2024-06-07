package com.circlezero.umc_application.web.controller;

import com.circlezero.umc_application.apiPayload.ApiResponse;
import com.circlezero.umc_application.converter.MissionConverter;
import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.service.missionService.MissionCommandService;
import com.circlezero.umc_application.web.dto.missionDTO.MissionRequestDTO;
import com.circlezero.umc_application.web.dto.missionDTO.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(
            @RequestBody @Valid MissionRequestDTO.CreateDto request
            ){
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
