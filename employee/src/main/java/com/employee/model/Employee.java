package com.employee.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotBlank(message =  "name should not be blank")
    @NotBlank(message = "name cannot be blank")
	@NotEmpty(message = "name cannot be empty")
    private String employeeName;

    @Min(value=18, message="must be equal or greater than 18")  
    @Max(value=60, message="must be equal or less than 60")  
    private Integer employeeAge;

    @Embedded
    private Address employeeAddress;

}
