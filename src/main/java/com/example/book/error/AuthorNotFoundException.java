package com.example.book.error;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super("Author is not found: "+id);
    }
}
