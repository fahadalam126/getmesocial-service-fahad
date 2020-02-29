package com.example.getmesocialsevice.repository;

import com.example.getmesocialsevice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String>  {
    void deleteByPhotoId(String photoId);

    List<Comment> findByPhotoId(String photoId);
 }
