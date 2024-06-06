package com.circlezero.umc_application.domain;

import com.circlezero.umc_application.domain.commons.BaseEntity;
import com.circlezero.umc_application.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefers = new ArrayList<>();
}
