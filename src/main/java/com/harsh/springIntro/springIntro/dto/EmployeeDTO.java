package com.harsh.springIntro.springIntro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // For getters, setters
@AllArgsConstructor
@NoArgsConstructor // Default constructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;

}