package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.FoodCategory;
import com.circlezero.umc_application.domain.mapping.MemberPrefer;

import java.util.List;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategories){
        return foodCategories.stream()
                .map(foodCategory -> {
                    return MemberPrefer.builder()
                            .foodCategory(foodCategory)
                            .build();
                }).toList();
    }
}
