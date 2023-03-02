package com.example.book.repository;

import com.example.book.entity.History;
import com.example.book.entity.HistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<History, HistoryId> {
}
