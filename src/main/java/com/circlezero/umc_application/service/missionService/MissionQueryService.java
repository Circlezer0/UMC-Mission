package com.circlezero.umc_application.service.missionService;

import com.circlezero.umc_application.domain.Mission;

import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
}
