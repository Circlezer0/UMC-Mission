package com.circlezero.umc_application.service.missionService;

import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.web.dto.missionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.CreateDto request);
    boolean isValidMission(Long id);
}
