package com.circlezero.umc_application.service.storeService;

import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.web.dto.storeDTO.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateDto request);
}
