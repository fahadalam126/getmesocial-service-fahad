package com.example.getmesocialsevice.resource;


import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialsevice.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileStorageResource {

    @Autowired
    private FileStorageService fileStorageService;

    @PutMapping
    public void uploadFile(@RequestParam(value = "file") MultipartFile file) {
        try {
            fileStorageService.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public void viewFile(@RequestParam(name = "key") String key, HttpServletResponse response) {
        S3Object object = fileStorageService.getFile(key);
        try {
            response.setContentType(object.getObjectMetadata().getContentType());
            //response.setContentType("image/jpeg");
            response.getOutputStream().write(object.getObjectContent().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam(name = "key") String key) {
        S3Object object = fileStorageService.getFile(key);
        try {
            ByteArrayResource resource = new ByteArrayResource(object.getObjectContent().readAllBytes());

            //Try to determine file's content type
            String contentType = object.getObjectMetadata().getContentType();;

            //Fallback to default content type if type could not be determined
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping
    public void deleteFile(@RequestParam("key") String key) {
        fileStorageService.deleteFile(key);
    }
}
