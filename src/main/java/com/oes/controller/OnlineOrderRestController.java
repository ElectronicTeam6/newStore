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
import com.oes.dto.UserOrderCreatedResponseDTO;
import com.oes.dto.UserReviewCreatedResponseDTO;
import com.oes.entity.User;
import com.oes.entity.OnlineOrder;
import com.oes.entity.Review;
import com.oes.service.UserService;
import com.oes.service.OrderService;
import com.oes.service.ReviewService;
import com.oes.util.UserDTOConvertor;

@RestController
@RequestMapping("/es/onlineorder")
public class OnlineOrderRestController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	//http://localhost:8888/es/onlineorder/user/sachi/onlineorder/8000/pending
	@PostMapping("/user/{username}/onlineorder/{totalOrderCost}/{status}")
	public ResponseEntity<MyDTO> addOrderByUser(@PathVariable String username,@PathVariable int totalOrderCost,@PathVariable String status )
	{
		
		User savedUser = null; 
		try {
		    savedUser = userService.getUserByUserName(username);
			if(savedUser != null)
			{
				OnlineOrder onlineorder = new OnlineOrder(totalOrderCost, LocalDate.now().toString(),status,null);
			//	Review post = new Review(description, LocalDate.now().toString(), 0, 0);
				OnlineOrder savedOrder = orderService.addOrder(onlineorder);
				
				if(savedOrder.getOnId() != 0)
				{
					// code to link post with user
					User updatedUserWithOrder = userService.addOrder(savedOrder, savedUser);
					
					UserOrderCreatedResponseDTO dto = UserDTOConvertor.getOrderCreatedDTO(updatedUserWithOrder,onlineorder);
					
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
