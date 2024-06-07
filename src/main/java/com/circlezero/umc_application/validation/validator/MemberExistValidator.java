package com.circlezero.umc_application.validation.validator;

import com.circlezero.umc_application.apiPayload.code.status.ErrorStatus;
import com.circlezero.umc_application.service.memberService.MemberCommandService;
import com.circlezero.umc_application.validation.annotation.ExistMember;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {
    private final MemberCommandService memberCommandService;
    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(CommonValidator.isNullId(value, context)){
            return false;
        }
        boolean isValid = memberCommandService.isValidMember(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    ErrorStatus.MEMBER_NOT_FOUND.toString()
            ).addConstraintViolation();
        }
        return isValid;
    }
}
