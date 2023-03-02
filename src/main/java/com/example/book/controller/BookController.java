package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.service.AuthorService;
import com.example.book.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Valid
@RestController
@Validated
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    Page<Book> findAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    Optional<Book> findById(@PathVariable @Min(1) Long id) {
        return bookService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Book saveBook(@Valid @RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    Book putBook(@RequestBody Book book, @PathVariable Long id){
        return bookService.updateBook(book, id);
    }

    @PatchMapping("/{id}")
    Book patchBook(@RequestBody Map<String, String> update, @PathVariable Long id){
        return bookService.patchBook(update, id);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    void deleteAllBook(){
        bookService.deleteAll();
    }

    @PostMapping("/saveAllBooks")
    public List<Book> saveAllBooks(@RequestBody List<Book> bookList){
        return bookService.saveAllBooks(bookList);
    }

}
