package com.singh.tenancy.endpoint;

import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenancy")
@Slf4j
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/getTenantById/{tenantId}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable Long tenantId) {
        log.info("Request received for endpoint '/getTenantById' Id : {}", tenantId);
        return new ResponseEntity(tenantService.getTenantDetailsById(tenantId), HttpStatus.OK);
    }

    @GetMapping("/getTenantByName/{tenantName}")
    public ResponseEntity<List<TenantDto>> getTenantByName(@PathVariable String tenantName) {
        log.info("Request received for endpoint '/getTenantByName' Name : {}", tenantName);
        return new ResponseEntity<>(tenantService.getTenantDetailsByName(tenantName), HttpStatus.OK);
    }

    @GetMapping("/getAllTenants")
    public ResponseEntity<List<TenantDto>> getAllTenants() {
        log.info("Request received for endpoint '/getAllTenants' ");
        return new ResponseEntity<>(tenantService.getAllTenants(), HttpStatus.OK);
    }

    @PutMapping("/updateTenant")
    public ResponseEntity<TenantDto> updateTenant(@RequestBody TenantDto inputTenant) {
        log.info("Request received for endpoint '/updateTenant', Request Body: {} ", inputTenant);
        return new ResponseEntity<>(tenantService.updateTenantDetails(inputTenant), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTenant/{tenantId}")
    public ResponseEntity deleteTenant(@PathVariable Long tenantId) {
        log.info("Request received for endpoint '/deleteTenant' Id : {}", tenantId);
        tenantService.deleteTenant(tenantId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/createTenant")
    public ResponseEntity<TenantDto> createTenant(@RequestBody TenantDto inputTenant) {
        log.info("Request received for endpoint '/createTenant', Request Body: {} ", inputTenant);
        return new ResponseEntity<>(tenantService.createTenant(inputTenant), HttpStatus.CREATED);
    }
}
