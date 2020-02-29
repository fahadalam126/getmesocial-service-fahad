package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.exception.InvalidAlbumIdException;
import com.example.getmesocialsevice.model.Photo;
import com.example.getmesocialsevice.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    AlbumService albumService;

    @GetMapping
    public List<Photo> getPhotos(){
        return photoRepository.findAll();
    }

    public void save(Photo photo) throws Exception {

        if(albumService.albumIdExists(photo.getAlbumId())){
            photoRepository.save(photo);
        } else if (!albumService.albumIdExists(photo.getAlbumId())){
            throw new InvalidAlbumIdException("Invalid Album Id");
        }
    }

    public void edit(Photo photo){
        photoRepository.save(photo);
    }

    public void delete(String photoId) {
        photoRepository.deleteById(photoId);

    }
    public void deleteByAlbumId(String albumId) {
        photoRepository.deleteByAlbumId(albumId);
    }

    public List<Photo> findAllPhotoByAlbumId(String albumId) {
        return photoRepository.findByAlbumId(albumId);
    }

    public boolean photoIdExist(String photoId) {
        return photoRepository.existsByPhotoId(photoId);
    }
}
