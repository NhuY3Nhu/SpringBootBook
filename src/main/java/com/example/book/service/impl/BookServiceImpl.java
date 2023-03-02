package com.example.book.service.impl;

import com.example.book.entity.Book;
import com.example.book.entity.Author;
import com.example.book.error.BookNotFoundException;
import com.example.book.error.BookUnSupportedFieldPatchException;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import jakarta.persistence.PreRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(@RequestBody Book newBook){
//        if(bookRepository.existsByBookName(newBook.getBookName())){
//            throw  new RuntimeException("This book existed");
//        }
        return bookRepository.save(newBook);
    }

    public Book updateBook(Book newBook, Long id) {
        return bookRepository.findById(id)
                .map(x -> {
                    x.setBookName(newBook.getBookName());
//                    x.setBookAuthor(newBook.getBookAuthor());
                    return bookRepository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setBookId(id);
                    return bookRepository.save(newBook);
                });
    }

    public Book patchBook(Map<String, String> update,Long id) {

        return bookRepository.findById(id)
                .map(x -> {
                    String bookAuthor = update.get("bookAuthor");
                    if (!StringUtils.isEmpty(bookAuthor)) {
                        return bookRepository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }
                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });
    }


    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        List<Book> books= bookRepository.findAll();
        for(Book book: new ArrayList<Book>(books)){
            book.removeAllAuthors();
        }
        bookRepository.deleteAll();

    }

    @Override
    public List<Book> saveAllBooks(List<Book> bookList){
        return bookRepository.saveAll(bookList);
    }
}
