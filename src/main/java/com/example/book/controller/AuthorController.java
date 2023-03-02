package com.example.book.controller;

import com.example.book.entity.Author;
import com.example.book.entity.Book;

import com.example.book.entity.Image;
import com.example.book.error.AuthorNotFoundException;
import com.example.book.repository.AuthorRepository;
import jakarta.validation.Valid;
import com.example.book.service.AuthorService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    List<Author> findAllAuthor() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    Author findById(@PathVariable @Min(1) Long id) {
        return authorService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Author saveAuthor(@RequestBody Author author){
        return authorService.save(author);
    }
    @PostMapping(path = "/upload-image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Author saveAuthor(@PathVariable Long id,
                            @RequestPart("image") MultipartFile[] file) throws IOException {
            Author author = authorService.findById(id);
            Set<Image> images = authorService.uploadImage(file);
            author.setAuthorImages(images);
            return authorService.save(author);
    }
    @PutMapping("/{id}")
    Author putAuthor(@RequestBody Author author, @PathVariable Long id){
        return authorService.updateAuthor(author, id);
    }

    @PatchMapping("/{id}")
    Author patchAuthor(@RequestBody Map<String, String> update, @PathVariable Long id){
        return authorService.patchAuthor(update, id);
    }

    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }

}
