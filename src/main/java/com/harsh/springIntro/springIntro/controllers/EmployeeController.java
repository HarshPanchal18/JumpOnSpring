package com.harsh.springIntro.springIntro.controllers;

// Operations:
// GET /employees
// POST /employees
// DELETE /employees/{id}

import com.harsh.springIntro.springIntro.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public ArrayList<EmployeeDTO> getEmployees(
            @PathParam("sortBy") String sortBy,
            @PathParam("sortBy") Integer limit
    ) {

        //limit = limit > 0 ? limit : 10;

        ArrayList<EmployeeDTO> employees = new ArrayList<>();

        employees.add(new EmployeeDTO(13L, "Panchal", LocalDate.of(2023, 10, 5), true));
        employees.add(new EmployeeDTO(12L, "Harsh", LocalDate.of(2024, 1, 5), true));

        if (sortBy != null && !sortBy.isEmpty()) {
            switch (sortBy.toLowerCase()) {
                case "id":
                    employees.sort(Comparator.comparingLong(EmployeeDTO::getId));
                    break;

                case "name":
                    employees.sort(Comparator.comparing(EmployeeDTO::getName));
                    break;

                case "date":
                    employees.sort(Comparator.comparing(EmployeeDTO::getDateOfJoining));
                    break;
            }
        }

        return employees;
    }

    @GetMapping(path = "/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empId) {
        return new EmployeeDTO(empId, "Harsh", LocalDate.of(2024, 1, 5), true);
    }

}