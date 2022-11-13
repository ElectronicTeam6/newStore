package com.oes.util;

import org.apache.catalina.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oes.dto.UserDefaultResponseDTO;
import com.oes.dto.UserDeliveryAgentCreatedResponseDTO;
import com.oes.dto.UserOrderCreatedResponseDTO;
import com.oes.dto.UserProductCreatedResponseDTO;
import com.oes.dto.UserReviewCreatedResponseDTO;
import com.oes.entity.DeliveryAgent;
import com.oes.entity.OnlineOrder;
import com.oes.entity.Product;
import com.oes.entity.Review;

@Component
@Scope("singleton")
public class UserDTOConvertor {

	public static UserDefaultResponseDTO  getUserDefaultDTO(com.oes.entity.User user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUsername(), 
				                 user.getId(), 
				                 user.getUserProfile().getEmail(),
				                 "User Profile Created , Profile Id : "+user.getUserProfile().getProfileId());
		
		return dto;
	}
	
	
	
	
	
	public static UserProductCreatedResponseDTO getProductCreatedDTO(com.oes.entity.User user,Product product)
	{
		UserProductCreatedResponseDTO dto = new UserProductCreatedResponseDTO(
				 user.getUsername(), 
                 user.getId(), 
                 product.getBrandName(),
                 "Product Added "+product.getDateOfLaunch()
                 );
				 
				 return dto;
	}
	public static UserOrderCreatedResponseDTO getOrderCreatedDTO(com.oes.entity.User user,OnlineOrder order)
	{
		UserOrderCreatedResponseDTO dto = new UserOrderCreatedResponseDTO(
				 user.getUsername(), 
                 user.getId(), 
                 order.getTotalOrderCost(),
                 order.getStatus(),
                 "Order Added" +order.getOrderDate()
                );
				 
				 return dto;
	}
	public static UserDeliveryAgentCreatedResponseDTO getDeliveryAgentCreatedDTO(com.oes.entity.User user,DeliveryAgent deliveryAgent)
	{
		UserDeliveryAgentCreatedResponseDTO dto = new UserDeliveryAgentCreatedResponseDTO(
				 user.getUsername(), 
                 user.getId(), 
                 deliveryAgent.getDeliveryStatus(),
                 deliveryAgent.getPayment(),
                 "DeliveryAgent Added" 
                 );
				 
				 return dto;
	}




	public static UserReviewCreatedResponseDTO getReviewCreatedDTO(com.oes.entity.User updatedUserWithReview,
			Review savedReview) {
		UserReviewCreatedResponseDTO dto = new UserReviewCreatedResponseDTO(
				updatedUserWithReview.getUsername(), 
				updatedUserWithReview.getId(), 
				savedReview.getDescription(),
                "Review Added "+savedReview.getDate()
                );
				 
				 return dto;
	}
}
