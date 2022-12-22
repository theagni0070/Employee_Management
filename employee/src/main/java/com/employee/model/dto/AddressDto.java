package com.employee.model.dto;

import com.employee.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    
    private Long employeeId;
    private Address address;

}
