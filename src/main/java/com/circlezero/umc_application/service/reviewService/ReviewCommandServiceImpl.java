package com.circlezero.umc_application.service.reviewService;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.apiPayload.exception.handler.MemberHandler;
import com.circlezero.umc_application.apiPayload.exception.handler.ReviewHandler;
import com.circlezero.umc_application.apiPayload.exception.handler.StoreHandler;
import com.circlezero.umc_application.converter.ReviewConverter;
import com.circlezero.umc_application.domain.Review;
import com.circlezero.umc_application.repository.ReviewRepository;
import com.circlezero.umc_application.service.memberService.MemberQueryService;
import com.circlezero.umc_application.service.storeService.StoreQueryService;
import com.circlezero.umc_application.web.dto.reviewDTO.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;

    @Override
    public Review createReview(ReviewRequestDTO.CreateDto request) {
        Float score = request.getScore();
        if(score < 1.0 || score > 5.0){
            throw new ReviewHandler(ErrorStatus.REVIEW_SCORE_VALUE_ERROR);
        }
        Review review = ReviewConverter.toReview(
                request,
                storeQueryService.findStore(request.getStoreId()).orElseThrow(
                        () ->
                                new StoreHandler(
                                        ErrorStatus.STORE_NOT_FOUND
                                )
                ),
                memberQueryService.findMember(request.getMemberId()).orElseThrow(
                        () ->
                                new MemberHandler(
                                        ErrorStatus.MEMBER_NOT_FOUND
                                )
                )

        );
        return reviewRepository.save(review);
    }
}
