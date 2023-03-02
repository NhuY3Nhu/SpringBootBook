package com.example.book.entity;

import ch.qos.logback.core.BasicStatusManager;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @NotEmpty(message = "Please provide a name")
    private String bookName;
    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal bookPrice;

    @ManyToMany()
    @JoinTable(
            name = "Author_write",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @NotNull(message = "Please provide author")
    private List<Author> writedByAuthors;

    public void removeAuthor(Author author) {
        this.writedByAuthors.remove(author);
        author.getBook().remove(this);
    }
    @PreRemove
    public void removeAllAuthors() {
        this.getWritedByAuthors().clear();
    }
}
