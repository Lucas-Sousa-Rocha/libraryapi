package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Model.Usuario;
import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Repository.Specs.LivroSpecs;
import com.quantumwebsystem.libraryapi.Security.SecurityService;
import com.quantumwebsystem.libraryapi.Validator.LivroValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroService {

    private final LivroValidator livroValidator;
    private final LivroRepository livroRepository;
    private final SecurityService securityService;

    public LivroService(LivroValidator livroValidator, LivroRepository livroRepository, SecurityService securityService) {
        this.livroValidator = livroValidator;
        this.livroRepository = livroRepository;
        this.securityService = securityService;
    }

    public void salvarLivro(Livro livro) {
        livroValidator.validarLivro(livro);
        Usuario usuario = securityService.obterusuarioLogado();
        livro.setUsuario(usuario);
        livroRepository.save(livro);
    }

    public Optional<Livro> obterDadosLivroPorId(UUID id){
        return livroRepository.findById(id);
    }

    public void excluirLivro(Livro livro){
        livroRepository.delete(livro);
    }

    public Page<Livro> pesquisa(String isbn, String titulo, String nomeAutor, GeneroLivro genero, Integer anoPublicacao, Integer pagina, Integer qtdPorPagina) {
        Specification<Livro> livroSpecification = Specification.allOf();

        if (isbn != null && !isbn.isBlank()) {
            livroSpecification = livroSpecification.and(LivroSpecs.isbnEquals(isbn));
        }
        if (titulo != null && !titulo.isBlank()) {
            livroSpecification = livroSpecification.and(LivroSpecs.tituloLike(titulo));
        }
        if (nomeAutor != null && !nomeAutor.isBlank()) {
            livroSpecification = livroSpecification.and(LivroSpecs.autorNomeLike(nomeAutor));
        }
        if (genero != null) {
            livroSpecification = livroSpecification.and(LivroSpecs.generoEquals(genero));
        }
        if (anoPublicacao != null) {
            livroSpecification = livroSpecification.and(LivroSpecs.anoPublicacaoEquals(anoPublicacao));
        }

        Pageable pagerequest = PageRequest.of(pagina, qtdPorPagina);

        return livroRepository.findAll(livroSpecification, pagerequest);
    }

    public void atualizarLivro(Livro livro) {
        if (livro.getId() == null) {
            throw new IllegalArgumentException("Erro, para atualizar o livro deve existir !!");
        }
        Usuario usuario = securityService.obterusuarioLogado();
        livro.setUsuario(usuario);
        livroValidator.validarLivro(livro);
        livroRepository.save(livro);
    }
}













