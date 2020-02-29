package com.example.getmesocialsevice.model;

import com.example.getmesocialsevice.validator.UniqueEmailAddress;
import com.example.getmesocialsevice.validator.UniqueProfilePhotoUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userId;

    @NotBlank(message = "Username must not be empty")
    private String name;

    @UniqueEmailAddress
    private String email;

    @UniqueProfilePhotoUrl
    private String profilePhotoUrl;

}
