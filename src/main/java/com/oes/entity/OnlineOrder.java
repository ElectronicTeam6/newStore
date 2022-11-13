package com.oes.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OO")
public class OnlineOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int onId;
	private int totalOrderCost;
	private String orderDate;
	private String status;
	private String username;

	


	public OnlineOrder(int totalOrderCost, String orderDate, String status, String userName) {
		super();
		this.totalOrderCost = totalOrderCost;
		this.orderDate = orderDate;
		this.status = status;
		this.username = userName;
	}

	
	
	
}
