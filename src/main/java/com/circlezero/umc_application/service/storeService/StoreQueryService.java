package com.circlezero.umc_application.service.storeService;

import com.circlezero.umc_application.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
