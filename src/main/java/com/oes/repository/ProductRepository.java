package com.oes.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oes.entity.Product;
import com.oes.entity.Review;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {
	Product save(Product product);

}
