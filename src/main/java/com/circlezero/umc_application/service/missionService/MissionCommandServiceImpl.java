package com.circlezero.umc_application.service.missionService;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.apiPayload.exception.handler.StoreHandler;
import com.circlezero.umc_application.converter.MissionConverter;
import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.repository.MissionRepository;
import com.circlezero.umc_application.service.storeService.StoreQueryService;
import com.circlezero.umc_application.web.dto.missionDTO.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;

    @Override
    public Mission createMission(MissionRequestDTO.CreateDto request) {
        Mission mission = MissionConverter.toMission(
                request,
                storeQueryService.findStore(request.getStoreId()).orElseThrow(
                        () ->
                                new StoreHandler(
                                        ErrorStatus.STORE_NOT_FOUND
                                )
                )
        );
        return missionRepository.save(mission);
    }
}
