package com.example.getmesocialsevice.resource;

import com.example.getmesocialsevice.model.Profile;
import com.example.getmesocialsevice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class ProfileResource {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/me")
    public Profile getProfile(){
        return profileService.getProfile();
    }


}