package com.singh.tenancy.dao;

import com.singh.tenancy.entity.TenantDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<TenantDetailsEntity, Long> {
    Optional<TenantDetailsEntity> findByName(String name);
}
