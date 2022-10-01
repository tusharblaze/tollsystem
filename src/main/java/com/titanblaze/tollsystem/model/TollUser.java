package com.titanblaze.tollsystem.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollUser {
	private String _id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private long phoneNumber;
	private List<Roles> roleType;
}
