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
import java.util.Comparator;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public ArrayList<EmployeeDTO> getEmployees(
            @PathParam("sortBy") String sortBy,
            @PathParam("sortBy") Integer limit
    ) {

        ArrayList<EmployeeDTO> employees = new ArrayList<>();

        employees.add(new EmployeeDTO(1L, "Smith", LocalDate.of(1990, 5, 15), true));
        employees.add(new EmployeeDTO(2L, "Johnson", LocalDate.of(1985, 8, 20), false));
        employees.add(new EmployeeDTO(3L, "Williams", LocalDate.of(1992, 3, 10), true));
        employees.add(new EmployeeDTO(4L, "Brown", LocalDate.of(1988, 11, 2), false));
        employees.add(new EmployeeDTO(5L, "Jones", LocalDate.of(1995, 7, 25), true));
        employees.add(new EmployeeDTO(6L, "Davis", LocalDate.of(1983, 12, 8), false));
        employees.add(new EmployeeDTO(7L, "Miller", LocalDate.of(1998, 4, 18), true));
        employees.add(new EmployeeDTO(8L, "Wilson", LocalDate.of(1980, 9, 30), false));
        employees.add(new EmployeeDTO(9L, "Moore", LocalDate.of(1991, 6, 12), true));
        employees.add(new EmployeeDTO(10L, "Taylor", LocalDate.of(1987, 1, 5), false));
        employees.add(new EmployeeDTO(11L, "Anderson", LocalDate.of(1993, 10, 22), true));
        employees.add(new EmployeeDTO(12L, "Thomas", LocalDate.of(1982, 2, 14), false));
        employees.add(new EmployeeDTO(13L, "Panchal", LocalDate.of(1999, 10, 5), true));
        employees.add(new EmployeeDTO(14L, "Harsh", LocalDate.of(2004, 1, 5), true));

        if (sortBy != null && !sortBy.isEmpty()) {
            switch (sortBy.toLowerCase()) {
                case "name":
                    employees.sort(Comparator.comparing(EmployeeDTO::getName));
                    break;

                case "date":
                    employees.sort(Comparator.comparing(EmployeeDTO::getDateOfJoining));
                    break;

                default:
                    employees.sort(Comparator.comparingLong(EmployeeDTO::getId));
                    break;
            }
        }

        if (limit == null)
            limit = 5;
        else if (limit > employees.size())
            limit = employees.size();

        limit = Math.max(0, limit); // Making limit non-negative

        ArrayList<EmployeeDTO> result = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++)
            result.add(employees.get(i));

        return result;
    }

    @GetMapping(path = "/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empId) {
        return new EmployeeDTO(empId, "Harsh", LocalDate.of(2024, 1, 5), true);
    }

}