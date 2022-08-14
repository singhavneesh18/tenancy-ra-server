package com.singh.tenancy.endpoint;

import com.singh.tenancy.dao.TenantRepository;
import com.singh.tenancy.dto.TenantDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenancy")
@Slf4j
public class TenantController {


    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping("/getTenantById/{tenantId}")
    public TenantDto getTenantById(@PathVariable Long tenantId) {
        log.info("Received request: {}", tenantRepository.findById(tenantId));
        return TenantDto.builder().name("New Tenant").build();
    }

    @GetMapping("/getTenantByName/{tenantName}")
    public TenantDto getTenantByName(@PathVariable String tenantName) {
        log.info("Received request: {}", tenantRepository.findByName(tenantName));
        return TenantDto.builder().name("New Tenant").build();
    }

    @GetMapping("/getAllTenants")
    public TenantDto getAllTenants() {
        log.info("Received request: {}", tenantRepository.findAll());
        return TenantDto.builder().name("New Tenant").build();
    }
}
