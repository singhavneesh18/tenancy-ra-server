package com.singh.tenancy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.singh.tenancy.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantDto {

    private Long id;
    private String name;
    private String permanentAddress;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime startDateOfRenting;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime endDateOfRenting;
    private boolean currentlyRenting;
    private String panNumber;
    private String aadharNumber;
    private String emailId;
}
