package com.singh.tenancy.mapper;

import com.singh.tenancy.dto.TenantDto;
import com.singh.tenancy.entity.TenantDetailsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenantResponseMapper {

    TenantResponseMapper TENANT_RESPONSE_MAPPER = Mappers.getMapper(TenantResponseMapper.class);

    TenantDto entityToTenantDto(TenantDetailsEntity tenantDetailsEntity);

    List<TenantDto> entityToTenantDtoList(List<TenantDetailsEntity> tenantDetailsEntity);

    @InheritInverseConfiguration
    @Mapping(target = "createdTs", ignore = true)
    @Mapping(target = "updatedTs", ignore = true)
    @Mapping(target = "id", ignore = true)
    TenantDetailsEntity dtoToTenantDetailsEntity(TenantDto tenantDto);
}
