package com.example.getmesocialsevice.validator;

import com.example.getmesocialsevice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueProfilePhotoUrlValidator implements ConstraintValidator<UniqueProfilePhotoUrl, String> {


    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueProfilePhotoUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String photoUrl, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.proPicExists(photoUrl);
    }
}
