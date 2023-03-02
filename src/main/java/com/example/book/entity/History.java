package com.example.book.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history")
public class History {
    @EmbeddedId
    private HistoryId id;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @MapsId("readerId")
    @JoinColumn(name="reader_id")
    private Reader reader;

    private LocalDate returnDay;
}
