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

    @Column(nullable = false, name = "dt_publicacao")
    private LocalDate dtPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(precision = 18, scale = 2 , nullable = false)
    private BigDecimal preco;

    // 1:N (um para muitos) | autor pode ter vários livros, mas cada livro pertence a apenas um autor
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @LastModifiedDate
    @Column(name = "dt_ultima_atualizacao")
    private LocalDateTime dtUltimaAtualizacao;

    @CreatedDate
    @Column(name = "dt_cadastro")
    private LocalDateTime dtCadastro;

    @Column(name = "id_usuario_ultima_atualizacao")
    private UUID idUsuarioUltimaAtualizacao;

    public Livro() {
    }

    public Livro(String isbn, String titulo, LocalDate dtPublicacao, GeneroLivro genero, BigDecimal preco, Autor autor, LocalDateTime dtUltimaAtualizacao, LocalDateTime dtCadastro, UUID idUsuarioUltimaAtualizacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.dtPublicacao = dtPublicacao;
        this.genero = genero;
        this.preco = preco;
        this.autor = autor;
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
        this.dtCadastro = dtCadastro;
        this.idUsuarioUltimaAtualizacao = idUsuarioUltimaAtualizacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDateTime getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }

    public void setDtUltimaAtualizacao(LocalDateTime dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public UUID getIdUsuarioUltimaAtualizacao() {
        return idUsuarioUltimaAtualizacao;
    }

    public void setIdUsuarioUltimaAtualizacao(UUID idUsuarioUltimaAtualizacao) {
        this.idUsuarioUltimaAtualizacao = idUsuarioUltimaAtualizacao;
    }
}

