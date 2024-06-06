package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
