package com.example.getmesocialsevice.repository;

import com.example.getmesocialsevice.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
    void deleteByAlbumId(String albumId);
    List<Photo> findByAlbumId(String albumId);
    boolean existsByPhotoId(String photoId);
}
