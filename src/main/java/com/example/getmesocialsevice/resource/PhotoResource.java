package com.example.getmesocialsevice.resource;

import com.example.getmesocialsevice.model.Photo;
import com.example.getmesocialsevice.service.CommentService;
import com.example.getmesocialsevice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {

    @Autowired
    PhotoService photoService;

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Photo> getPhotos(){
        return photoService.getPhotos();
    }

    @PostMapping
    public void savePhoto(@RequestBody Photo photo) throws Exception {
        photoService.save(photo);
    }

    @PutMapping("/{photoId}")
    public void editPhoto(Photo photo, @PathVariable("photoId") String photoId){
        photo.setPhotoId(photoId);
        photoService.edit(photo);
    }

    @DeleteMapping("/{photoId}")
    public void deletePhoto(@PathVariable("photoId") String photoId){
        commentService.deleteByPhotoId(photoId);
        photoService.delete(photoId);
    }


}

