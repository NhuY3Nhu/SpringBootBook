package com.example.book.service.impl;

import com.example.book.entity.History;
import com.example.book.repository.BorrowRepository;
import com.example.book.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public History saveBorrow(History history){
        return borrowRepository.save(history);
    }
}
