package com.quantumwebsystem.libraryapi.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private LocalDate dt_nascimento;

    @Column(length = 50)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    @LastModifiedDate
    @Column
    private LocalDateTime dt_ultima_atualizacao;

    @CreatedDate
    @Column
    private LocalDateTime dt_cadastro;

    @Column
    private UUID id_usuario_ultima_atualizacao;

    public Autor() {}

    public Autor(String nome, LocalDate dt_nascimento, String nacionalidade, List<Livro> livros, LocalDateTime dt_ultima_atualizacao, LocalDateTime dt_cadastro, UUID id_usuario_ultima_atualizacao) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.nacionalidade = nacionalidade;
        this.livros = livros;
        this.dt_ultima_atualizacao = dt_ultima_atualizacao;
        this.dt_cadastro = dt_cadastro;
        this.id_usuario_ultima_atualizacao = id_usuario_ultima_atualizacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public UUID getId_usuario_ultima_atualizacao() {
        return id_usuario_ultima_atualizacao;
    }

    public void setId_usuario_ultima_atualizacao(UUID id_usuario_ultima_atualizacao) {
        this.id_usuario_ultima_atualizacao = id_usuario_ultima_atualizacao;
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
}
