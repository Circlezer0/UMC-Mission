package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.Review;
import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewRequestDTO;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDto request, Store store, Member member){
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();
    }
}
