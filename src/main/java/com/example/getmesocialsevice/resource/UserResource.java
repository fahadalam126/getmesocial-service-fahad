package com.example.getmesocialsevice.resource;

import com.amazonaws.services.securitytoken.model.InvalidIdentityTokenException;
import com.example.getmesocialsevice.exception.MyCustomException;
import com.example.getmesocialsevice.model.User;
import com.example.getmesocialsevice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser(@RequestParam("userId") String userId) {
        return userService.getByUserId(userId);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User saveUser(@Validated @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public User editUser(@RequestParam("userId") String userId, @RequestBody User user) throws Exception {

        throw new MyCustomException("My custom message");

        // check the validity of the userId first
//        User oldUser = userService.getByUserId(userId);
//        user.setUserId(userId);
//        return userService.editUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam("userId") String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/me")
    public User me(@RequestParam("idToken") String idToken) {
        if(userService.isValidUser(idToken)) {
            String email = userService.firebaseUser.getEmail();
            return userService.getByEmail(email);
        } else {
            throw new InvalidIdentityTokenException("Token Invalid ...");
        }
    }

}

