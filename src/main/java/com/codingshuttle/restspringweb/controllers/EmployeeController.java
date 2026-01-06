package com.codingshuttle.restspringweb.controllers;

import com.codingshuttle.restspringweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySecretMessage() {
//        return "Secret message : yegf7832$%^nb";
//    }

    //path variable
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return new EmployeeDTO(id, "Yash","skylineapi@gmailcom",27, LocalDate.of(2026,1,6),true);
    }


    @GetMapping
    public String getAllEmployee(@RequestParam(required = false) Integer age,
                                 @RequestParam(required = false) String sortBy){
        return "Hi Age "+age+" "+sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        return "Hello from POST";
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeeById(){
        return "Hello from Put";
    }

}
