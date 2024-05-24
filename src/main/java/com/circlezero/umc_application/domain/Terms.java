package com.circlezero.umc_application.domain;

import com.circlezero.umc_application.domain.commons.BaseEntity;
import com.circlezero.umc_application.domain.mapping.MemberToTerm;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Terms extends BaseEntity {
    @Id
    private Long id;

    @Column(length = 20)
    private String title;

    @Lob
    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberToTerm> memberAgreeList = new ArrayList<>();
}
