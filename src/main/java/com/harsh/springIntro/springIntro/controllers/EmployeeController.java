package com.harsh.springIntro.springIntro.controllers;

// Operations:
// GET /employees
// POST /employees
// DELETE /employees/{id}

import com.harsh.springIntro.springIntro.dto.EmployeeDTO;
import com.harsh.springIntro.springIntro.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteByEmployeeId(id);
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
        //return new EmployeeDTO(empId, "Harsh", LocalDate.of(2024, 1, 5), true);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }
}