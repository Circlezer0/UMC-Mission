package com.circlezero.umc_application.service.regionService;

import com.circlezero.umc_application.domain.Region;

import java.util.Optional;

public interface RegionQueryService {
    Optional<Region> findRegion(Long id);
}
