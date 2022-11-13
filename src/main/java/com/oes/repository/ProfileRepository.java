package com.oes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.oes.entity.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
