package com.oes.service;
import java.util.List;


import org.springframework.stereotype.Service;

import com.oes.entity.DeliveryAgent;
import com.oes.entity.OnlineOrder;
import com.oes.entity.Review;


@Service
public interface DeliveryAgentService {
public DeliveryAgent addDeliveryAgent(DeliveryAgent deliveryAgent);
	
	public List<DeliveryAgent> getAllDeliveryAgentbyUser(String username)throws Exception;



}
