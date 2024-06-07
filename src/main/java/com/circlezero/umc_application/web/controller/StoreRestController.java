package com.circlezero.umc_application.web.controller;

import com.circlezero.umc_application.apiPayload.ApiResponse;
import com.circlezero.umc_application.converter.MemberConverter;
import com.circlezero.umc_application.converter.StoreConverter;
import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.service.storeService.StoreCommandService;
import com.circlezero.umc_application.web.dto.memberDto.MemberRequestDTO;
import com.circlezero.umc_application.web.dto.memberDto.MemberResponseDTO;
import com.circlezero.umc_application.web.dto.storeDTO.StoreRequestDTO;
import com.circlezero.umc_application.web.dto.storeDTO.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    @PostMapping("/create")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.CreateDto request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }
}
