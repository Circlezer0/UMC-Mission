package com.circlezero.umc_application.web.dto.reviewDTO;

import com.circlezero.umc_application.validation.annotation.ExistMember;
import com.circlezero.umc_application.validation.annotation.ExistRegion;
import com.circlezero.umc_application.validation.annotation.ExistStore;
import jakarta.validation.constraints.*;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateDto {
        @NotBlank
        String title;

        @NotBlank
        String body;

        @NotNull
        @Positive
        Float score;

        @ExistStore
        Long storeId;

        @ExistMember
        Long memberId;

        // ReviewImage 관련 코드 추가해야 함
    }
}
