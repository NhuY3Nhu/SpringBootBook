package com.example.book.controller;

import com.example.book.entity.Reader;
import com.example.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    List<Reader> findAll(){
        return readerService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Reader saveReader(@RequestBody Reader reader){
        return readerService.saveReader(reader);
    }
}
