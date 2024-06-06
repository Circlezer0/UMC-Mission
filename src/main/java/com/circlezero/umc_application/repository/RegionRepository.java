package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
