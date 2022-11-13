package com.oes.service;

import org.springframework.stereotype.Service;

import com.oes.entity.Profile;



@Service
public interface ProfileService {

	public Profile addProfile(Profile profile);
}
