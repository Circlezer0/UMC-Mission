package com.circlezero.umc_application.web.dto.missionDTO;

import com.circlezero.umc_application.validation.annotation.ExistStore;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateDto {
        @NotNull
        Integer reward;

        @NotNull
        @Future
        LocalDate deadline;

        @NotBlank
        String missionSpec;

        @ExistStore
        Long storeId;
    }
}
