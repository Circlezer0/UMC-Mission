package com.circlezero.umc_application.service.reviewService;

import com.circlezero.umc_application.domain.Review;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.CreateDto request);
}
