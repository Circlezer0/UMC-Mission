package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.Region;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.web.dto.storeDTO.StoreRequestDTO;
import com.circlezero.umc_application.web.dto.storeDTO.StoreResponseDTO;

public class StoreConverter {


    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
