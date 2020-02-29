package com.example.getmesocialsevice.model;

import com.example.getmesocialsevice.validator.UniqueCoverPhotoUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "albums")
public class Album {

    @Id
    private String albumId;

    @Size(min = 4, max = 10)
    private String name;

    @UniqueCoverPhotoUrl
    private String coverPhotoUrl;

    private String createdBy;
    private Date dateCreated;

}
