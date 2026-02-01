package com.codingshuttle.restspringweb.dto;

import com.codingshuttle.restspringweb.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Required field in Employee : Name")
    @Size(min = 3,max = 10, message = "name length should be between [3,10]")
    private String name;

    @NotBlank(message = "email of an employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @Max(value = 80, message = "Age cannot be be more than 80")
    @Min(value = 18, message = "Age cannot be less than 18")
    private Integer age;

    @NotBlank(message = "role of an employee cannot be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$", message = "role can be admin or user")
    @EmployeeRoleValidation
    private String role; //ADMIN OR USER

    @Positive(message = "salary cannot be negative")
    @NotNull(message = "salary cannot be null")
    @Digits(integer = 6, fraction = 2, message = "salary should be in form XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DOJ should be past date")
    private LocalDate dateOfJoining;

    @AssertTrue
    @JsonProperty("isActive")
    private Boolean isActive;

}
