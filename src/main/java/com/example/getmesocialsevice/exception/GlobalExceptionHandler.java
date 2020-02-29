package com.example.getmesocialsevice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>globalExceptionHandler(Exception e, WebRequest request){
        return new ResponseEntity<>("Error Error Error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<?>customExceptionHandler(Exception e, WebRequest request){
        return new ResponseEntity<>("Error Error Error " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidAlbumIdException.class)
    public ResponseEntity<?>invalidAlbumIdExceptionHandler(Exception e, WebRequest request){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPhotoIdException.class)
    public ResponseEntity<?>InvalidPhotoIdExceptionHandler(Exception e, WebRequest request){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
