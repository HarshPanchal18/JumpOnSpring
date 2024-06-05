package com.harsh.springIntro.springIntro.controllers;

// Operations:
// GET /employees
// POST /employees
// DELETE /employees/{id}

import com.harsh.springIntro.springIntro.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public ArrayList<EmployeeDTO> getEmployees() {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();

        employees.add(new EmployeeDTO(12L, "Harsh", LocalDate.of(2024, 1, 5), true));
        employees.add(new EmployeeDTO(13L, "Panchal", LocalDate.of(2024, 1, 5), true));

        return employees;
    }

    @GetMapping(path = "/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long empId) {
        return new EmployeeDTO(empId, "Harsh", LocalDate.of(2024, 1, 5), true);
    }

}