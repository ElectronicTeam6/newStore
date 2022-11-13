package com.oes.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserProductCreatedResponseDTO implements MyDTO {
	private String username;
	private int userId;
	private String  brandName;
	private String remarks;
}
