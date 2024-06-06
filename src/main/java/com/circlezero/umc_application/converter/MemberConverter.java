package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.enums.Gender;
import com.circlezero.umc_application.web.dto.memberDto.MemberRequestDTO;
import com.circlezero.umc_application.web.dto.memberDto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthDay(request.getBirthDay())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
