package com.circlezero.umc_application.service.foodCategoryService;

import com.circlezero.umc_application.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService{
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean isValidCategories(List<Long> idList) {
        return idList.stream().allMatch(foodCategoryRepository::existsById);
    }
}
