package com.example.book.service;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookService {


    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);

    Book save(@RequestBody Book book);

    Book updateBook(Book book, Long id);

    Book patchBook(Map<String, String> update, Long id);

    void deleteById(Long id);

    void deleteAll();
    List<Book> saveAllBooks(@RequestBody List<Book> bookList);
}
