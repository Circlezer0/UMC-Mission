package com.circlezero.umc_application.service.memberService;

import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
    boolean isValidMember(Long id);
}
