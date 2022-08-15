package com.singh.tenancy.service;

import com.singh.tenancy.dto.TenantDto;

import java.util.List;

public interface TenantService {
    TenantDto getTenantDetailsById(Long tenantId);
    List<TenantDto> getTenantDetailsByName(String tenantName);
    List<TenantDto> getAllTenants();

    TenantDto updateTenantDetails(TenantDto inputDto);
}
