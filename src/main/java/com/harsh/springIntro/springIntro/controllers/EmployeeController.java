package com.harsh.springIntro.springIntro.controllers;

// Operations:
// GET /employees
// POST /employees
// DELETE /employees/{id}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public String getEmployees() {
        return "Hello World!";
    }
}