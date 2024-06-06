package com.circlezero.umc_application.apiPayload.exception.handler;

import com.circlezero.umc_application.apiPayload.code.BaseErrorCode;
import com.circlezero.umc_application.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode baseErrorCode){
        super(baseErrorCode);
    }
}
