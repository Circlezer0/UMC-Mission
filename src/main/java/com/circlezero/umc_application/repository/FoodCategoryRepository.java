package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
