package com.example.getmesocialsevice.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.example.getmesocialsevice.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private void uploadFileToS3bucket(String fileName, File file) {
        AWSCredentials credentials = new BasicAWSCredentials(
                Constants.AWS_S3_KEY,
                Constants.AWS_S3_PRIVATE_KEY
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        s3client.putObject(new PutObjectRequest("backend-fahad", fileName, file)
        .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public void uploadFile(MultipartFile multipartFile) throws IOException {

        ObjectMetadata data = new ObjectMetadata();
        data.setContentType(multipartFile.getContentType());
        data.setContentLength(multipartFile.getSize());

        BasicAWSCredentials credentials = new BasicAWSCredentials(
                Constants.AWS_S3_KEY,
                Constants.AWS_S3_PRIVATE_KEY
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        PutObjectResult objectResult = s3client.putObject("backend-fahad", "images/" + multipartFile.getOriginalFilename(), multipartFile.getInputStream(), data);

    }

    public S3Object getFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                Constants.AWS_S3_KEY,
                Constants.AWS_S3_PRIVATE_KEY
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        return s3client.getObject("backend-fahad", key);
    }

    public void deleteFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                Constants.AWS_S3_KEY,
                Constants.AWS_S3_PRIVATE_KEY
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        s3client.deleteObject("backend-fahad", key);
    }
}
