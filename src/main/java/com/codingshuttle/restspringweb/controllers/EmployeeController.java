package com.codingshuttle.restspringweb.controllers;

import com.codingshuttle.restspringweb.dto.EmployeeDTO;
import com.codingshuttle.restspringweb.entities.EmployeeEntity;
import com.codingshuttle.restspringweb.repositories.EmployeeRepository;
import com.codingshuttle.restspringweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySecretMessage() {
//        return "Secret message : yegf7832$%^nb";
//    }

//    private final EmployeeRepository employeeRepository;

//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //path variable
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
//        return new EmployeeDTO(id, "Yash","skylineapi@gmailcom",27, LocalDate.of(2026,1,6),true);

        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
//        if(employeeDTO == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false) Integer age,
                                            @RequestParam(required = false) String sortBy) {
//        return "Hi Age "+age+" "+sortBy;

//        return employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
//        return "Hello from POST";
//        inputEmployee.setId(100L);z
//        return inputEmployee;

//        return employeeService.createNewEmployee(inputEmployee);
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));

    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
//        return employeeService.deleteEmployeeById(employeeId);

    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId,updates);
        if(employeeDTO ==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}


























