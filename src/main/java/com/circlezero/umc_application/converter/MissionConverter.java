package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.web.dto.missionDTO.MissionRequestDTO;
import com.circlezero.umc_application.web.dto.missionDTO.MissionResponseDTO;

import java.util.ArrayList;

public class MissionConverter {

    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateDto request, Store store){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
