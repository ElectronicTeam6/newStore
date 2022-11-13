package com.oes.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entity.Review;
import com.oes.repository.ReviewRepository;
import com.oes.repository.UserRepository;
@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Review addReview(Review review) {
		Review savedPost = reviewRepository.save(review);
		return savedPost;
	}

	@Override
	public List<Review> getAllReviewbyUser(String username) throws Exception {

		User user = (User) userRepository.getUsersByUsername(username);
		
		
		return null;
	}

}
