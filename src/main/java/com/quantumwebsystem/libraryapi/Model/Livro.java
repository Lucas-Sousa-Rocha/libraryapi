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

    @Column(length = 20, nullable = false, unique = true)
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

    @ManyToOne
    @JoinColumn(name = "id_usuario_ultima_atualizacao")
    private Usuario usuario;

    public Livro() {}

    public Livro(Usuario usuario, LocalDateTime dtCadastro, LocalDateTime dtUltimaAtualizacao, Autor autor, BigDecimal preco, GeneroLivro genero, LocalDate dtPublicacao, String titulo, String isbn) {
        this.usuario = usuario;
        this.dtCadastro = dtCadastro;
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
        this.autor = autor;
        this.preco = preco;
        this.genero = genero;
        this.dtPublicacao = dtPublicacao;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public LocalDateTime getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }

    public void setDtUltimaAtualizacao(LocalDateTime dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

