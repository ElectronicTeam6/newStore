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
import com.oes.dto.UserDeliveryAgentCreatedResponseDTO;
import com.oes.dto.UserReviewCreatedResponseDTO;
import com.oes.entity.User;
import com.oes.entity.DeliveryAgent;
import com.oes.entity.Review;
import com.oes.service.UserService;
import com.oes.service.DeliveryAgentService;
import com.oes.service.ReviewService;
import com.oes.util.UserDTOConvertor;

@RestController
@RequestMapping("/es/deliveryAgent")
public class DeliveryAgentRestController {
	@Autowired
	DeliveryAgentService deliveryAgentService;
	
	@Autowired
	UserService userService;
	
	//http://localhost:8888/es/deliveryAgent/user/sachi/deliveryAgent/shipped/cash on delivery
	@PostMapping("/user/{username}/deliveryAgent/{deliveryStatus}/{payment}")
	public ResponseEntity<MyDTO> addDeliveryAgentByUser(@PathVariable String username,@PathVariable String deliveryStatus,@PathVariable String payment)
	{
		
		User savedUser = null; 
		try {
		    savedUser = userService.getUserByUserName(username);
			if(savedUser != null)
			{
				DeliveryAgent deliveryAgent = new DeliveryAgent(deliveryStatus, payment,username);
			//	Review post = new Review(description, LocalDate.now().toString(), 0, 0);
				DeliveryAgent savedDeliveryAgent = deliveryAgentService.addDeliveryAgent(deliveryAgent);
				
				if(savedDeliveryAgent.getDeliveryAgentId() != 0)
				{
					// code to link post with user
					User updatedUserWithDeliveryAgent = userService.addDeliveryAgent(savedDeliveryAgent, savedUser);
					
					UserDeliveryAgentCreatedResponseDTO dto = UserDTOConvertor.getDeliveryAgentCreatedDTO(updatedUserWithDeliveryAgent,deliveryAgent);
					
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
