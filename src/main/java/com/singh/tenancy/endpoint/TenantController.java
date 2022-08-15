package com.singh.tenancy.endpoint;

import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenancy")
@Slf4j
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/getTenantById/{tenantId}")
    public TenantDto getTenantById(@PathVariable Long tenantId) {
        log.info("Request received for endpoint '/getTenantById' Id : {}", tenantId);
        return tenantService.getTenantDetailsById(tenantId);
    }

    @GetMapping("/getTenantByName/{tenantName}")
    public List<TenantDto> getTenantByName(@PathVariable String tenantName) {
        log.info("Request received for endpoint '/getTenantByName' Name : {}", tenantName);
        return tenantService.getTenantDetailsByName(tenantName);
    }

    @GetMapping("/getAllTenants")
    public List<TenantDto> getAllTenants() {
        log.info("Request received for endpoint '/getAllTenants' ");
        return tenantService.getAllTenants();
    }

    @PutMapping("/updateTenant")
    public TenantDto updateTenant(@RequestBody TenantDto inputTenant) {
        log.info("Request received for endpoint '/updateTenant', Request Body: {} ", inputTenant);
        return tenantService.updateTenantDetails(inputTenant);
    }

    @DeleteMapping("/deleteTenant/{tenantId}")
    public void deleteTenant(@PathVariable Long tenantId) {
        log.info("Request received for endpoint '/deleteTenant' Id : {}", tenantId);
        tenantService.deleteTenant(tenantId);
    }

    @PostMapping("/createTenant")
    public TenantDto createTenant(@RequestBody TenantDto inputTenant) {
        log.info("Request received for endpoint '/createTenant', Request Body: {} ", inputTenant);
        return tenantService.createTenant(inputTenant);
    }
}
