package com.oes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OEProfile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	//@NotNull(message = "Username cannot be Null")
	@Size(min = 2,message = "Username is not valid, should have more than 2 characters")
	private String fullName;
	private String username;
	private String city;
	private String locations;
	@Email(message = "Not a valid email")
	private String email;
	@PositiveOrZero(message = "Invalid Phone Number")
	//@Pattern(regexp = "[0-9]{10}",message = "Phone number is not valid")
	private long phoneNumber;
	
	
	
	public Profile(String fullName, String city,String username, String locations, String email, long phoneNumber) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.city = city;
		this.locations = locations;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
	}


}
