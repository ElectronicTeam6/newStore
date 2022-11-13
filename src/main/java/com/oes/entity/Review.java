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
@Table(name = "OEReview")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	private String description;
	private String date;
	private String username;
	private String productName;
	private String title;
	private int rating;
	
	public Review(String description, String date, String userName, String productName, String title, int rating) {
		super();
		this.description = description;
		this.date = date;
		this.username = userName;
		this.productName = productName;
		this.title = title;
		this.rating = rating;
	}
	
	

	
}
