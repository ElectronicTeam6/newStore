package com.oes.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oes.entity.DeliveryAgent;
import com.oes.entity.OnlineOrder;
import com.oes.entity.Product;
import com.oes.entity.Review;


@Repository
public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer> {

}
