package com.circlezero.umc_application.validation.annotation;

import com.circlezero.umc_application.validation.validator.CategoriesExistValidator;
import com.circlezero.umc_application.validation.validator.RegionExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegionExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {
    String message() default "해당하는 지역이 존재하지 않습니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}