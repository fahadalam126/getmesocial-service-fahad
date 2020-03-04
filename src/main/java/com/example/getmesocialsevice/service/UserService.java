package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.model.FirebaseUser;
import com.example.getmesocialsevice.model.User;
import com.example.getmesocialsevice.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public FirebaseUser firebaseUser;

    public User getByUserId(String userId) {
        return userRepository.findById(userId).get();
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    //for validation
    public boolean emailExists(String email){
        return userRepository.existsByEmail(email);
     }

    public boolean proPicExists(String photoUrl) {
         return userRepository.existsByProfilePhotoUrl(photoUrl);
    }

    public boolean isValidUser(String idToken) {

        try {
            String uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
            String name = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
            String email = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();

            if (!StringUtils.isEmpty(uid) && !StringUtils.isEmpty(email)) {
                FirebaseUser firebaseUser = new FirebaseUser(uid, name, email);
                this.firebaseUser = firebaseUser;
                return true;
            } else {
                return false;
            }

        } catch (InterruptedException | ExecutionException e) {
            this.firebaseUser = null;
            return false;
        }
    }
}
