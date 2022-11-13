package com.oes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entity.Profile;
import com.oes.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile addProfile(Profile profile) {
		
		Profile savedProfile = profileRepository.save(profile);
		
		return savedProfile;
	}
	
	


}
