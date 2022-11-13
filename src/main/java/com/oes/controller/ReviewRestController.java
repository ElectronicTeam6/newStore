package com.oes.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oes.dto.ErrorDTO;
import com.oes.dto.MyDTO;
import com.oes.dto.UserDefaultResponseDTO;
import com.oes.dto.UserReviewCreatedResponseDTO;
import com.oes.entity.User;
import com.oes.entity.Review;
import com.oes.service.UserService;
import com.oes.service.ReviewService;
import com.oes.util.UserDTOConvertor;

@RestController
@RequestMapping("/es/review")
public class ReviewRestController {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	UserService userService;
	
	//http://localhost:8888/es/review/user/ross/review/chair/pls buy this/its nice product
	@PostMapping("/user/{username}/review/{productName}/{description}/{title}")
	public ResponseEntity<MyDTO> addReviewByUser(@PathVariable String username,@PathVariable String description,@PathVariable String productName,@PathVariable String title)
	{
		
		User savedUser = null; 
		try {
		    savedUser = userService.getUserByUserName(username);
			if(savedUser != null)
			{
				Review review = new Review(description, LocalDate.now().toString(), username, productName, title, 0);
			//	Review post = new Review(description, LocalDate.now().toString(), 0, 0);
				Review savedReview = reviewService.addReview(review);
				
				if(savedReview.getReviewId() != 0)
				{
					// code to link post with user
					User updatedUserWithReview = userService.addReview(savedReview, savedUser);
					
					UserReviewCreatedResponseDTO dto = UserDTOConvertor.getReviewCreatedDTO(updatedUserWithReview,review);
					
					return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
				}
				
			}
			else
			{
				throw new Exception("User not found "+savedUser+" for "+username);
			}
			
		} catch (Exception e) {
			System.out.println(savedUser+" is not");
			
			ErrorDTO errorDto = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		return null;
		
	}


}
