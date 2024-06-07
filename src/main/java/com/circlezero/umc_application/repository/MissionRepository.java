package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
