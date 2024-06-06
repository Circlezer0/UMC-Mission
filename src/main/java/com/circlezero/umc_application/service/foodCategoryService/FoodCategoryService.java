package com.circlezero.umc_application.service.foodCategoryService;

import java.util.List;

public interface FoodCategoryService {
    boolean isValidCategories(List<Long> idList);
}
