package com.harsh.springIntro.springIntro.services;

import com.harsh.springIntro.springIntro.dto.EmployeeDTO;
import com.harsh.springIntro.springIntro.entities.EmployeeEntity;
import com.harsh.springIntro.springIntro.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        //return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
        return modelMapper.map(employeeEntity, EmployeeDTO.class); // Mapping Entity into DTO object
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employees = new ArrayList<>();
        for (EmployeeEntity empEntity : employeeRepository.findAll()) {
            employees.add(modelMapper.map(empEntity, EmployeeDTO.class));
        }
        return employees;
    }

    public Boolean deleteByEmployeeId(Long id) {
        boolean isEmpPresent = employeeRepository.existsById(id);
        if (isEmpPresent) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}