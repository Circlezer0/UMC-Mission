package com.circlezero.umc_application.apiPayload.exception.handler;

import com.circlezero.umc_application.apiPayload.code.BaseErrorCode;
import com.circlezero.umc_application.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}