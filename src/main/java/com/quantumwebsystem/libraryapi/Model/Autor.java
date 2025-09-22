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

    @Column(nullable = false, name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(length = 50)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    @LastModifiedDate
    @Column(name = "dt_ultima_atualizacao")
    private LocalDateTime dtUltimaAtualizacao;

    @CreatedDate
    @Column(name = "dt_cadastro")
    private LocalDateTime dtCadastro;

    @Column(name = "id_usuario_ultima_atualizacao")
    private UUID idUsuarioUltimaAtualizacao;

    public Autor() {}

    public Autor(UUID id, String nome, LocalDate dtNascimento, String nacionalidade, List<Livro> livros, LocalDateTime dtUltimaAtualizacao, LocalDateTime dtCadastro, UUID idUsuarioUltimaAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.nacionalidade = nacionalidade;
        this.livros = livros;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
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
