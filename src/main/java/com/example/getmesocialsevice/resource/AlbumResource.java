package com.example.getmesocialsevice.resource;

import com.example.getmesocialsevice.exception.InvalidAlbumIdException;
import com.example.getmesocialsevice.model.Album;
import com.example.getmesocialsevice.model.Photo;
import com.example.getmesocialsevice.service.AlbumService;
import com.example.getmesocialsevice.service.CommentService;
import com.example.getmesocialsevice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    @Autowired
    PhotoService photoService;

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @PostMapping
    public void saveAlbum(@Validated @RequestBody Album album) throws InvalidAlbumIdException {
        albumService.save(album);
    }

    @PutMapping("/{albumId}")
    public void editAlbum(Album album, @PathVariable("albumId") String albumId){
        album.setAlbumId(albumId);
        albumService.edit(album);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbum(@PathVariable("albumId") String albumId){

        List<Photo> photos =  photoService.findAllPhotoByAlbumId(albumId);
        for(Photo photo: photos) {
            commentService.deleteByPhotoId(photo.getPhotoId());
        }
        photoService.deleteByAlbumId(albumId);
        albumService.delete(albumId);

    }
}
