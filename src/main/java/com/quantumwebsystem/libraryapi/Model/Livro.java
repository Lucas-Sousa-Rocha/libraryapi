package com.quantumwebsystem.libraryapi.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Livro{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDate dt_publicacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(precision = 18, scale = 2 , nullable = false)
    private BigDecimal price;

    // 1:N (um para muitos) | autor pode ter vários livros, mas cada livro pertence a apenas um autor
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @LastModifiedDate
    @Column
    private LocalDateTime dt_ultima_atualizacao;

    @CreatedDate
    @Column
    private LocalDateTime dt_cadastro;

    @Column
    private UUID id_usuario_ultima_atualizacao;

    public Livro() {}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDt_publicacao() {
        return dt_publicacao;
    }

    public void setDt_publicacao(LocalDate dt_publicacao) {
        this.dt_publicacao = dt_publicacao;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDateTime getDt_ultima_atualizacao() {
        return dt_ultima_atualizacao;
    }

    public void setDt_ultima_atualizacao(LocalDateTime dt_ultima_atualizacao) {
        this.dt_ultima_atualizacao = dt_ultima_atualizacao;
    }

    public LocalDateTime getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(LocalDateTime dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public UUID getId_usuario_ultima_atualizacao() {
        return id_usuario_ultima_atualizacao;
    }

    public void setId_usuario_ultima_atualizacao(UUID id_usuario_ultima_atualizacao) {
        this.id_usuario_ultima_atualizacao = id_usuario_ultima_atualizacao;
    }
}

