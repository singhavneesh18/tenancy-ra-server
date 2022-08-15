package com.singh.tenancy.service.impl;

import com.singh.tenancy.dao.TenantRepository;
import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.entity.TenantDetailsEntity;
import com.singh.tenancy.mapper.TenantResponseMapper;
import com.singh.tenancy.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private TenantResponseMapper tenantResponseMapper;

    @Override
    public TenantDto getTenantDetailsById(Long tenantId) {
        Optional<TenantDetailsEntity> tenantDetails = tenantRepository.findById(tenantId);
        return getTenantFromOptional(tenantDetails);
    }

    @Override
    public TenantDto getTenantDetailsByName(String tenantName) {
        Optional<TenantDetailsEntity> tenantDetails = tenantRepository.findByName(tenantName);
        return getTenantFromOptional(tenantDetails);
    }

    private TenantDto getTenantFromOptional(Optional<TenantDetailsEntity> tenantDetails) {
        if (tenantDetails.isEmpty()) {
            return TenantDto.builder().build();
        } else {
            return tenantResponseMapper.mapToTenantDto(tenantDetails.get());
        }
    }

}
