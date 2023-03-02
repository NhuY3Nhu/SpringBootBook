package com.example.book.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String imageName;
    private String type;
    @Lob
    @Column(length = 50000000)
    private byte[] image;

    public Image(String imageName, String type, byte[] image) {
        this.imageName = imageName;
        this.type = type;
        this.image = image;
    }
}
