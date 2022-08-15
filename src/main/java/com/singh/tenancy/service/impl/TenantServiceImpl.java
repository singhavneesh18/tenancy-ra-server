package com.singh.tenancy.service.impl;

import com.singh.tenancy.dao.TenantRepository;
import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.entity.TenantDetailsEntity;
import com.singh.tenancy.exception.NoDataFoundException;
import com.singh.tenancy.mapper.TenantResponseMapper;
import com.singh.tenancy.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
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
        List<TenantDetailsEntity> detailsEntityList = tenantRepository.findByNameContainingIgnoreCase(tenantName);
        return tenantResponseMapper.entityToTenantDtoList(detailsEntityList);
    }

    @Override
    public List<TenantDto> getAllTenants() {
        List<TenantDetailsEntity> detailsEntityList = tenantRepository.findAll();
        return tenantResponseMapper.entityToTenantDtoList(detailsEntityList);
    }

    private TenantDto getTenantFromOptional(Optional<TenantDetailsEntity> tenantDetails) {
        if (tenantDetails.isEmpty()) {
            throw new NoDataFoundException("No Tenat details found ");
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
            TenantDetailsEntity savedEntity = tenantRepository.save(tenantDetailsEntity);
            log.info("Updated successfully ..");
            return tenantResponseMapper.entityToTenantDto(savedEntity);
        } else {
            throw new NoDataFoundException("No TenantDetails found with Id: " + inputDto.getId());
        }
    }

    @Override
    public void deleteTenant(Long tenantId) {
        tenantRepository.deleteById(tenantId);//Handle EmptyResultDataAccessException
    }

    @Override
    public TenantDto createTenant(TenantDto inputDto) {
        TenantDetailsEntity tenantDetailsEntity = tenantRepository.save(tenantResponseMapper.dtoToTenantDetailsEntity(inputDto));
        return tenantResponseMapper.entityToTenantDto(tenantDetailsEntity);
    }


}
