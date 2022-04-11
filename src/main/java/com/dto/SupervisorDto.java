package com.dto;

import lombok.Data;

@Data
public class SupervisorDto {

    private Long id;

    private Integer employeeId;

    private String firstName;

    private String team;

    private String lastName;
}
