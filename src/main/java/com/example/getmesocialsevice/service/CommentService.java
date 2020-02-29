package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.exception.InvalidPhotoIdException;
import com.example.getmesocialsevice.model.Comment;
import com.example.getmesocialsevice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    PhotoService photoService;

    @GetMapping
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public void save(Comment comment) throws Exception {
        if(photoService.photoIdExist(comment.getPhotoId())){
            commentRepository.save(comment);
        } else if (!photoService.photoIdExist(comment.getPhotoId())){
            throw new InvalidPhotoIdException("invalid Photo Id");
        }

    }

    public void edit(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(String commentId) {
        commentRepository.deleteById(commentId);
    }
    public void deleteByPhotoId(String photoId) {
        commentRepository.deleteByPhotoId(photoId);
    }

//    public List<Comment> findAllCommentByPhotoId(String photoId) {
//        return commentRepository.findByPhotoId(photoId);
//    }

}
