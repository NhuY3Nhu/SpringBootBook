package com.example.book.service.impl;

import com.example.book.entity.Author;
import com.example.book.entity.Book;
import com.example.book.entity.Image;
import com.example.book.error.BookNotFoundException;
import com.example.book.error.BookUnSupportedFieldPatchException;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findByAuthorId(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> images=new HashSet<>();

        for (MultipartFile file:multipartFiles){
            Image image = new Image(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            images.add(image);
        }
        return images;
    }

    public Author updateAuthor(Author newAuthor, Long id) {
        return authorRepository.findById(id)
                .map(x -> {
                    x.setAuthorName(newAuthor.getAuthorName());
                    return authorRepository.save(x);
                })
                .orElseGet(() -> {
                    newAuthor.setAuthorId(id);
                    return authorRepository.save(newAuthor);
                });
    }

    public Author patchAuthor(Map<String, String> update, Long id) {

        return authorRepository.findById(id)
                .map(x -> {
                    String authorName = update.get("authorName");
                    if (!StringUtils.isEmpty(authorName)) {
                        return authorRepository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }
                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });
    }
//
//    public void checkBookNull(Long id){
//        Author author=authorRepository.findByAuthorId(id);
//        Book book=new Book();
//        book.removeAuthor(author);
//        if(book.getWritedByAuthors().isEmpty()){
//            bookRepository.delete(book);
//        }
//    }
//
//    public void deleteById(Long id) {
//        Author author=authorRepository.findByAuthorId(id);
//        List<Book> list = author.getBook();
//        for(Book book: new ArrayList<Book>(list)){
//            author.removeBook(book);
//            checkBookNull(id);
//        }
//        authorRepository.delete(author);
//    }

    public void deleteById(Long id) {
        Author author=authorRepository.findByAuthorId(id);
        List<Book> list = author.getBook();
        for(Book book: new ArrayList<Book>(list)){
            author.removeBook(book);
            book.removeAuthor(author);
            if (book.getWritedByAuthors().isEmpty()) {
                bookRepository.delete(book);
            }
        }
        authorRepository.delete(author);
    }
}
