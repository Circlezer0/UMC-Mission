package com.circlezero.umc_application.repository;

import com.circlezero.umc_application.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
