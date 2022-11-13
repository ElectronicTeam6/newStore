package com.oes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oes.entity.User;


@Repository
public interface IAppUserCustomRepository {

	public List<User> getAllUsersByRole(String role)throws Exception;
	public User getUsersByUsername(String username)throws Exception;
	
	@Query("from User where userId >= :range1 and userId <= :range2")
	public List<User> getUsersBetweenIds(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	
}
