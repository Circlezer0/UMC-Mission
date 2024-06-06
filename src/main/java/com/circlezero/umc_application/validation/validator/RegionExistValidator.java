package com.circlezero.umc_application.validation.validator;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.service.regionService.RegionCommandService;
import com.circlezero.umc_application.validation.annotation.ExistRegion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionCommandService regionCommandService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = regionCommandService.isValidRegion(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.REGION_NOT_FOUND.toString()
            ).addConstraintViolation();
        }
        return isValid;
    }
}
