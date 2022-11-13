package com.oes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oes.entity.DeliveryAgent;
import com.oes.entity.OnlineOrder;
import com.oes.entity.Product;
import com.oes.entity.Profile;
import com.oes.entity.Review;
import com.oes.entity.User;



@Service
public interface UserService {
	public List<User> getAllUsers()throws Exception;
	public List<User> getAllUsers(String role)throws Exception;
	public User getUserByUserName(String username)throws Exception;
	public List<User> getUsersConnections(String username)throws Exception;
	public User getUserByUserNameAndRole(String username,String role)throws Exception;
	public List<User> getUsersByRole(String role)throws Exception;
	public List<User> getUsersBetweenIds(int range1,int range2)throws Exception;
	public User getUserById(int searchedUserId)throws Exception;
	
	public List<Review> getAllReviews(String username);
	
	
	public User insertUser(User user)throws Exception;
//	public User addProduct(List<String> allProducts,User user); //HOBBIES
	public User addReview(Review review,User user);
	
	
	public User linkProfile(Profile profile,User user);
	public User addProduct(Product savedProduct, User savedUser);
	public User addOrder(OnlineOrder savedOrder, User savedUser)throws Exception;
	public User addDeliveryAgent(DeliveryAgent savedDeliveryAgent, User savedUser)throws Exception;
	public User addDeliveryAgents(List<DeliveryAgent> allDeliveryAgents, User savedUser)throws Exception;
	public User updateUser(User u)throws Exception;
	public boolean deleteUserById(int id)throws Exception;
	public boolean updateUserById(int id, User user)throws Exception;


}
