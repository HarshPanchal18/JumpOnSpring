package com.harsh.springIntro.springIntro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    // Before: true -> false
    @JsonProperty("isActive") // For clean boolean value in response
    // After: true -> true
    private boolean isActive;

}