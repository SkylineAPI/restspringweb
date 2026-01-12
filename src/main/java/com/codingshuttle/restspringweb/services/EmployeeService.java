package com.codingshuttle.restspringweb.services;


import com.codingshuttle.restspringweb.dto.EmployeeDTO;
import com.codingshuttle.restspringweb.entities.EmployeeEntity;
import com.codingshuttle.restspringweb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;


    public EmployeeDTO getEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        ModelMapper mapper = new ModelMapper();
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }



    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {

        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);

        EmployeeEntity savedEmployeeEntity= employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }


}
