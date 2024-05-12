package com.example.HWSpring6.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "text", nullable = false)
    String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
