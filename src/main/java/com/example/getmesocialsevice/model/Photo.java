package com.example.getmesocialsevice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "photos")
public class Photo {

    @Id
    private String photoId;
    private String albumId;
    private String photoUrl;
    private String createdBy;
    private Date dateCreated;

}
