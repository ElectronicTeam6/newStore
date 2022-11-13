package com.oes.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserOrderCreatedResponseDTO implements MyDTO {

	private String username;
	private int userId;
	private int totalOrderCost;
	private String status;
	private String orderDate;
}
