package com.example.book.controller;

import com.example.book.entity.History;
import com.example.book.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public History saveBorrow(@RequestBody History history){
        return borrowService.saveBorrow(history);
    }

}
