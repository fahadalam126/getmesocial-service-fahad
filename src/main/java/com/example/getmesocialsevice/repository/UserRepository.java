package com.example.getmesocialsevice.repository;

import com.example.getmesocialsevice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByProfilePhotoUrl(String photoUrl);
    boolean existsByEmail(String email);
}
