package com.circlezero.umc_application.domain.mapping;

import com.circlezero.umc_application.domain.FoodCategory;
import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member){
        if(this.member != null){
            member.getMemberPreferList().remove(this);
        }
        this.member = member;
        member.getMemberPreferList().add(this);
    }

}