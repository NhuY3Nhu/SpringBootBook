package com.example.book.service;

import com.example.book.entity.Author;
import com.example.book.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    Author save(Author author);

    Author updateAuthor(Author Author, Long id);

    Author patchAuthor(Map<String, String> update, Long id);

    void deleteById(Long id);

    Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException;
    
}
