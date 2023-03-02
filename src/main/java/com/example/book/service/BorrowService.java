package com.example.book.service;

import com.example.book.entity.History;
import org.springframework.stereotype.Service;

public interface BorrowService {
    History saveBorrow(History history);
}
