package com.employee.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    
    @NotBlank(message =  "Areaname should not be blank")
    @NotBlank(message = "Areaname cannot be blank")
	@NotEmpty(message = "Areaname cannot be empty")
    private String areaName;

    @Size(min=1,message="Flatno required") 
    private String flatNo;

    @Size(min = 6,max = 6,message = "pincode size should be 6")
    private Integer pinCode;

}
