package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
