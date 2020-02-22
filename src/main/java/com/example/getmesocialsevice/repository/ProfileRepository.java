package com.example.getmesocialsevice.repository;

import com.example.getmesocialsevice.model.Address;
import com.example.getmesocialsevice.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    public Profile getProfile(){
        Profile profile = new Profile("Fahad", 27, new Address("Richland", "USA", "99354"), "5092050490");
        return profile;
    }
}
