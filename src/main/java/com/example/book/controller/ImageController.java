package com.example.book.controller;

import com.example.book.entity.Image;
import com.example.book.model.MessageResponse;
import com.example.book.repository.ImageRepository;
import com.example.book.service.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ImageController {
//    @Autowired
//    ImageService imageService;
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @PostMapping("/upload")
//    public ResponseEntity<MessageResponse> uploadImage(@RequestParam("image")MultipartFile file){
//        String message="";
//        try {
//            imageService.store(file);
//
//            message="Uploaded the file successfully: " +file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
//        }catch (Exception e){
//            message="Could not upload the file: "+file.getOriginalFilename()+"!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
//        }
//    }
//
////    @Transactional
////    public Image getInfoByImageByName(String name){
////        Optional<Image> dbImage=imageRepository.findByName(name);
////
////        return Image.builder()
////                .
////    }

}
