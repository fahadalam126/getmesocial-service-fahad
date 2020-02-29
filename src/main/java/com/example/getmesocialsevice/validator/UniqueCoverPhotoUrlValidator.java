package com.example.getmesocialsevice.validator;

import com.example.getmesocialsevice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCoverPhotoUrlValidator implements ConstraintValidator<UniqueCoverPhotoUrl, String> {

    @Autowired
    private AlbumService albumService;

    @Override
    public void initialize(UniqueCoverPhotoUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String coverPhotoUrl, ConstraintValidatorContext constraintValidatorContext) {
        return !albumService.coverPicExists(coverPhotoUrl);
    }
}
