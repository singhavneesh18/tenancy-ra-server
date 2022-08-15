package com.singh.tenancy.dao;

import com.singh.tenancy.entity.TenantDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<TenantDetailsEntity, Long> {
    List<TenantDetailsEntity> findByNameContaining(@NonNull String name);
}
