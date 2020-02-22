package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.model.Profile;
import com.example.getmesocialsevice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile getProfile(){
        return profileRepository.getProfile();
    }
}

