package com.singh.tenancy.service;

import com.singh.tenancy.dto.TenantDto;

public interface TenantService {
    TenantDto getTenantDetailsById(Long tenantId);
    TenantDto getTenantDetailsByName(String tenantName);
}
