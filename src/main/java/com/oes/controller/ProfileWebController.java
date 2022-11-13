package com.oes.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oes.dto.ErrorDTO;
import com.oes.dto.MyDTO;
import com.oes.dto.UserDefaultResponseDTO;
import com.oes.entity.User;
import com.oes.entity.Profile;
import com.oes.service.UserService;
import com.oes.service.ProfileService;
import com.oes.util.UserDTOConvertor;

@RestController
@RequestMapping("es/profile")
@Validated
public class ProfileWebController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDTOConvertor dtoConvertor;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/add") //http://localhost:8888/es/profile/add?username=sachi
	public ResponseEntity<MyDTO> doProfileThings(@RequestBody @Valid Profile profile,@RequestParam String username)
	{
		User alreadySavedUser = null;
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doprofile things");
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedUser = userService.getUserByUserName(username);
				if(alreadySavedUser != null)
				{
					User profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);
					
					UserDefaultResponseDTO dtoResponse = dtoConvertor.getUserDefaultDTO(profileAddUser);
					
					return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
				}
				else
				{
					mylogs.error("User not found in post mapping uri : add");
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+username);
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
		
		// code to add the profile
	}


}
