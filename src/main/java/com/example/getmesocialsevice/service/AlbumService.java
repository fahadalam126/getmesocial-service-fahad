package com.example.getmesocialsevice.service;

import com.example.getmesocialsevice.model.Album;
import com.example.getmesocialsevice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> getAlbums(){
        return albumRepository.findAll();
    }

    public void save(Album album) {
        albumRepository.save(album);
    }

    public void edit(Album album) {
        albumRepository.save(album);
    }

    public void delete(String albumId) {
        albumRepository.deleteById(albumId);
    }

    //Validating
    public boolean coverPicExists(String coverPhotoUrl) {
        return albumRepository.existsByCoverPhotoUrl(coverPhotoUrl);
    }

    // For Exception handling
    public Album findByAlbumId(String albumId){
        return albumRepository.findByAlbumId(albumId);
    }

    public boolean albumIdExists(String albumId){
        return albumRepository.existsByAlbumId(albumId);
    }

}
