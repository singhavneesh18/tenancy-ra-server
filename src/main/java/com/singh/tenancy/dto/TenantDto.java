package com.singh.tenancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantDto {

    private Long id;
    private String name;
    private String permanentAddress;
    private LocalDateTime startDateOfRenting;
    private LocalDateTime endDateOfRenting;
    private boolean currentlyRenting;
    private String panNumber;
    private String aadharNumber;
    private String emailId;
}
