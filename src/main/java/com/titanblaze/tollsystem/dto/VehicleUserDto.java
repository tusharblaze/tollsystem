package com.titanblaze.tollsystem.dto;

import com.titanblaze.tollsystem.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleUserDto {

	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private Vehicle vehicle;
	private String reciptId;
}
