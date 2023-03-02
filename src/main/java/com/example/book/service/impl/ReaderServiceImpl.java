package com.example.book.service.impl;

import com.example.book.entity.Reader;
import com.example.book.repository.ReaderRepository;
import com.example.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> findAll(){
        return readerRepository.findAll();
    }
    @Override
    public Reader saveReader(@RequestBody Reader reader){
        return readerRepository.save(reader);
    }
}
