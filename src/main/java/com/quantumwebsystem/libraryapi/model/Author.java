package com.quantumwebsystem.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false)
    private LocalDate dt_birth;

    @Column(length = 50)
    private String nationality;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {}
}
