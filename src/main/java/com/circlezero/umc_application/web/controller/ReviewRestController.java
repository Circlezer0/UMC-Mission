package com.circlezero.umc_application.web.controller;

import com.circlezero.umc_application.apiPayload.ApiResponse;
import com.circlezero.umc_application.converter.ReviewConverter;
import com.circlezero.umc_application.converter.StoreConverter;
import com.circlezero.umc_application.domain.Review;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.service.reviewService.ReviewCommandService;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewRequestDTO;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewResponseDTO;
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
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/create")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.CreateDto request
            ){
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
