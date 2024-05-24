package com.circlezero.umc_application.domain;

import com.circlezero.umc_application.domain.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
