package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.model.Album;
import com.example.getmesocialsevice.model.User;
import com.example.getmesocialsevice.repository.AlbumRepository;
import com.example.getmesocialsevice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByUserId(String userId) {
        return userRepository.findById(userId).get();
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
}
