package com.example.getmesocialsevice.repository;

import com.example.getmesocialsevice.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {
    Album findByName(String name);
    boolean existsByCoverPhotoUrl(String coverPhotoUrl);
    Album findByAlbumId(String albumId);
    boolean existsByAlbumId(String albumId);
}
