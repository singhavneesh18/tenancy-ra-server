package com.singh.tenancy.endpoint;

import com.singh.tenancy.dao.TenantRepository;
import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.service.TenantService;
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

    @Autowired
    private TenantService tenantService;

    @GetMapping("/getTenantById/{tenantId}")
    public TenantDto getTenantById(@PathVariable Long tenantId) {
        log.info("Request received for endpoint '/getTenantById' Id : {}", tenantId);
        return tenantService.getTenantDetailsById(tenantId);
    }

    @GetMapping("/getTenantByName/{tenantName}")
    public TenantDto getTenantByName(@PathVariable String tenantName) {
        log.info("Request received for endpoint '/getTenantByName' Name : {}", tenantName);
        return tenantService.getTenantDetailsByName(tenantName);
    }

    @GetMapping("/getAllTenants")
    public TenantDto getAllTenants() {
        log.info("Received request: {}", tenantRepository.findAll());
        return TenantDto.builder().name("New Tenant").build();
    }
}
