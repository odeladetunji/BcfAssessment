package com.dto;

import lombok.Data;

@Data
public class SubordinateDto {

    private Long id;

    private Integer employeeId;

    private Integer supervisorId;

    private String firstName;

    private String lastName;

    private String team;
}
