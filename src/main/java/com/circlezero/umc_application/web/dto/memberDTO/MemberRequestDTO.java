package com.circlezero.umc_application.web.dto.memberDTO;

import com.circlezero.umc_application.validation.annotation.ExistCategories;
import com.circlezero.umc_application.validation.annotation.ExistMember;
import com.circlezero.umc_application.validation.annotation.ExistMission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    public static class StartMissionDTO {
        @ExistMember
        Long memberId;

        @ExistMission
        Long missionId;
    }
}
