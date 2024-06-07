package com.circlezero.umc_application.converter;

import com.circlezero.umc_application.domain.Member;
import com.circlezero.umc_application.domain.Mission;
import com.circlezero.umc_application.domain.mapping.MemberToMission;
import com.circlezero.umc_application.web.dto.memberDTO.MemberResponseDTO;

public class MemberToMissionConverter {

    public static MemberResponseDTO.StartMissionResultDTO toStartMissionResult(MemberToMission memberToMission){
        return MemberResponseDTO.StartMissionResultDTO.builder()
                .memberId(memberToMission.getMember().getId())
                .missionId(memberToMission.getMission().getId())
                .missionStatus(memberToMission.getStatus().toString())
                .build();
    }
}
