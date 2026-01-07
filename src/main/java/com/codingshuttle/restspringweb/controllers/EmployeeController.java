package com.codingshuttle.restspringweb.controllers;

import com.codingshuttle.restspringweb.dto.EmployeeDTO;
import com.codingshuttle.restspringweb.entities.EmployeeEntity;
import com.codingshuttle.restspringweb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySecretMessage() {
//        return "Secret message : yegf7832$%^nb";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //path variable
    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
//        return new EmployeeDTO(id, "Yash","skylineapi@gmailcom",27, LocalDate.of(2026,1,6),true);

        return employeeRepository.findById(id).orElse(null);
    }


    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age,
                                               @RequestParam(required = false) String sortBy){
//        return "Hi Age "+age+" "+sortBy;

        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        return "Hello from POST";
//        inputEmployee.setId(100L);
//        return inputEmployee;

        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployeeById(){
        return "Hello from Put";
    }

}
