package com.circlezero.umc_application.service.memberService;

import com.circlezero.umc_application.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
}
