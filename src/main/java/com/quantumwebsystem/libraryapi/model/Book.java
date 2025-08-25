package com.quantumwebsystem.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate dt_publication;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private GenderBook gender;

    @Column(precision = 18, scale = 2 , nullable = false)
    private BigDecimal price;

    // 1:N (um para muitos) | autor pode ter vários livros, mas cada livro pertence a apenas um autor
    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    public Book() {}
}

