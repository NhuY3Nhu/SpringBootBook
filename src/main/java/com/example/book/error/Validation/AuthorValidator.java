package com.example.book.error.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class AuthorValidator implements ConstraintValidator<Author, String> {

    List<String> authors = Arrays.asList("Santideva", "Marie Kondo", "Martin Fowler", "mkyong");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return authors.contains(value);
    }
}
