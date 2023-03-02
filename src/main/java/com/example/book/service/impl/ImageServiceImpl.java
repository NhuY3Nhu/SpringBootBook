package com.example.book.service.impl;

import com.example.book.entity.Image;
import com.example.book.repository.ImageRepository;
import com.example.book.service.ImageService;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public class ImageServiceImpl implements ImageService {

//    @Autowired
//    ImageRepository imageRepository;
//
//    @Override
//    public Image store(MultipartFile file) throws IOException{
//        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
//        Image image=new Image(fileName, file.getContentType(), file.getBytes());
//
//        return imageRepository.save(image);
//    }
//
//    @Override
//    public Stream<Image> getAllFiles(){
//        return imageRepository.findAll().stream();
//    }
//
//    @Override
//    public Image saveImage(Image image){
//       return imageRepository.save(image);
//    }
}
