package com.circlezero.umc_application.service.regionService;

import com.circlezero.umc_application.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService{
    private final RegionRepository regionRepository;
    @Override
    public boolean isValidRegion(Long id) {
        return regionRepository.existsById(id);
    }
}
