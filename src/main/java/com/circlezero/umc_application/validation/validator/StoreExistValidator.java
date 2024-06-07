package com.circlezero.umc_application.validation.validator;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.service.storeService.StoreCommandService;
import com.circlezero.umc_application.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreCommandService storeCommandService;
    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(CommonValidator.isNullId(value, context)){
            return false;
        }
        boolean isValid = storeCommandService.isValidStore(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.STORE_NOT_FOUND.toString()
            ).addConstraintViolation();
        }
        return isValid;
    }
}
