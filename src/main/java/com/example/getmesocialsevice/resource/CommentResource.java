package com.example.getmesocialsevice.resource;

import com.example.getmesocialsevice.model.Comment;
import com.example.getmesocialsevice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getComments(){
        return commentService.getComments();
    }

    @PostMapping
    public void saveComment(@Validated @RequestBody Comment comment) throws Exception {
        commentService.save(comment);
    }

    @PutMapping("/{commentId}")
    public void editComment(Comment comment, @PathVariable("commentId") String commentId){
        comment.setCommentId(commentId);
        commentService.edit(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") String commentId){
        commentService.delete(commentId);
    }
}