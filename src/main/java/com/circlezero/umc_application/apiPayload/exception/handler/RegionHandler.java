package com.circlezero.umc_application.apiPayload.exception.handler;

import com.circlezero.umc_application.apiPayload.code.BaseErrorCode;
import com.circlezero.umc_application.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode code) {
        super(code);
    }
}
