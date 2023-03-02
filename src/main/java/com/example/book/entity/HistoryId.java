package com.example.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@EqualsAndHashCode
public class HistoryId implements Serializable {

    @Column(name = "reader_id")
    private Long reader;
    @Column(name = "book_id")
    private Long book;
    @Column(name = "borrow_day", nullable = false)
    private LocalDateTime borrowedDay;
}
