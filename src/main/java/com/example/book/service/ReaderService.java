package com.example.book.service;

import com.example.book.entity.Reader;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReaderService {

    List<Reader> findAll();
    Reader saveReader(@RequestBody Reader reader);
}
