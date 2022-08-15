package com.singh.tenancy.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity(name = "tenant_details")
@Data
public class TenantDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "tenant_name")
    private String name;

    private String permanentAddress;
    private LocalDateTime startDateOfRenting;
    private LocalDateTime endDateOfRenting;
    private boolean currentlyRenting;
    private String panNumber;
    private String aadharNumber;
    private String emailId;
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;

}
