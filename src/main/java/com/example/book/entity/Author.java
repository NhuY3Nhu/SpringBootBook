package com.example.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String authorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_image",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private Set<Image> authorImages;


    @ManyToMany(mappedBy = "writedByAuthors")
    @JsonIgnore//Bỏ không hiện cột ra ngoài
    private List<Book> book;

//    public void addBook(Book book) {
//        this.book.add(book);
//        book.getWritedByAuthors().add(this);
//    }
    public void removeBook(Book book) {
        this.book.remove(book);
        book.getWritedByAuthors().remove(this);
    }


}
