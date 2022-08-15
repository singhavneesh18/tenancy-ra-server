package com.singh.tenancy.service.impl;

import com.singh.tenancy.dao.TenantRepository;
import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.entity.TenantDetailsEntity;
import com.singh.tenancy.mapper.TenantResponseMapper;
import com.singh.tenancy.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
    public List<TenantDto> getTenantDetailsByName(String tenantName) {
        List<TenantDetailsEntity> detailsEntityList = tenantRepository.findByNameContaining(tenantName);
        return tenantResponseMapper.entityToTenantDtoList(detailsEntityList);
    }

    @Override
    public List<TenantDto> getAllTenants() {
        List<TenantDetailsEntity> detailsEntityList = tenantRepository.findAll();
        return tenantResponseMapper.entityToTenantDtoList(detailsEntityList);
    }

    private TenantDto getTenantFromOptional(Optional<TenantDetailsEntity> tenantDetails) {
        if (tenantDetails.isEmpty()) {
            return TenantDto.builder().build();//TODO return empty with 404 not found, Need to throw an Exception with code 404
        } else {
            return tenantResponseMapper.entityToTenantDto(tenantDetails.get());
        }
    }

    @Override
    public TenantDto updateTenantDetails(TenantDto inputDto) {
        Optional<TenantDetailsEntity> entity = tenantRepository.findById(inputDto.getId());
        if (entity.isPresent()) {
            final TenantDetailsEntity tenantDetailsEntity = entity.get();
            tenantDetailsEntity.setName(inputDto.getName());
            tenantDetailsEntity.setPermanentAddress(inputDto.getPermanentAddress());
            if (inputDto.isCurrentlyRenting())
                tenantDetailsEntity.setEndDateOfRenting(LocalDateTime.now());
            tenantDetailsEntity.setCurrentlyRenting(inputDto.isCurrentlyRenting());
            tenantDetailsEntity.setPanNumber(inputDto.getPanNumber());
            tenantDetailsEntity.setAadharNumber(inputDto.getAadharNumber());
            tenantDetailsEntity.setEmailId(inputDto.getEmailId());
            TenantDetailsEntity savedEntity = null;//tenantRepository.save(tenantDetailsEntity);
            return tenantResponseMapper.entityToTenantDto(savedEntity);
        } else {
            // throw an exception, not found unable to update
            return null;
        }
    }


}
