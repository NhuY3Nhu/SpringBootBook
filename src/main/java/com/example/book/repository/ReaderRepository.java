package com.example.book.repository;

import com.example.book.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
ReaderRepository extends JpaRepository<Reader, Long> {
}
