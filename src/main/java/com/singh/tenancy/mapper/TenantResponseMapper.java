package com.singh.tenancy.mapper;

import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.entity.TenantDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TenantResponseMapper {

    TenantResponseMapper TENANT_RESPONSE_MAPPER = Mappers.getMapper(TenantResponseMapper.class);

    TenantDto mapToTenantDto(TenantDetailsEntity tenantDetailsEntity);
}
