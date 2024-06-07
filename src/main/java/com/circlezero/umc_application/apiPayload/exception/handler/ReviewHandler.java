package com.circlezero.umc_application.apiPayload.exception.handler;

import com.circlezero.umc_application.apiPayload.code.BaseErrorCode;
import com.circlezero.umc_application.apiPayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode code) {
        super(code);
    }
}
