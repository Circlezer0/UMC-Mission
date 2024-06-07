package com.circlezero.umc_application.service.storeService;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.apiPayload.exception.handler.FoodCategoryHandler;
import com.circlezero.umc_application.apiPayload.exception.handler.RegionHandler;
import com.circlezero.umc_application.converter.StoreConverter;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.repository.RegionRepository;
import com.circlezero.umc_application.repository.StoreRepository;
import com.circlezero.umc_application.service.regionService.RegionQueryService;
import com.circlezero.umc_application.web.dto.storeDTO.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionQueryService regionQueryService;

    @Override
    public Store createStore(StoreRequestDTO.CreateDto request) {
        Store store = StoreConverter.toStore(
                request, regionQueryService.findRegion(request.getRegionId()).orElseThrow(
                        () ->
                                new RegionHandler(
                                        ErrorStatus.REGION_NOT_FOUND
                                )
                ));
        return storeRepository.save(store);
    }

    @Override
    public boolean isValidStore(Long id) {
        return storeRepository.existsById(id);
    }
}
