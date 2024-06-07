package com.circlezero.umc_application.web.dto.storeDTO;

import com.circlezero.umc_application.validation.annotation.ExistCategories;
import com.circlezero.umc_application.validation.annotation.ExistRegion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class CreateDto {
        @NotBlank
        String name;
        @NotBlank
        @Size(min = 5, max = 50)
        String address;
        @ExistRegion
        Long regionId;
    }
}
