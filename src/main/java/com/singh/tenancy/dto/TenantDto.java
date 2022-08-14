package com.singh.tenancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantDto {

    private Long id;
    private String name;
    private String permanentAddress;
    private LocalDate startDateOfRent;
    private LocalDate endDateOfRent;
    private boolean isRenting;
    private String photo;
    private IdType idType;
    private String attachedIdTypes;
}
