package com.circlezero.umc_application.service.regionService;

import com.circlezero.umc_application.domain.Region;
import com.circlezero.umc_application.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService{
    private final RegionRepository regionRepository;
    @Override
    public Optional<Region> findRegion(Long id) {
        return regionRepository.findById(id);
    }
}
