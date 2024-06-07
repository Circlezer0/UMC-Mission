package com.circlezero.umc_application.service.storeService;

import com.circlezero.umc_application.domain.Store;
import com.circlezero.umc_application.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }
}
