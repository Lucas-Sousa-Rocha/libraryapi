package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Repository.Specs.LivroSpecs;
import com.quantumwebsystem.libraryapi.Validator.LivroValidator;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroService {

    private final LivroValidator livroValidator;
    private final LivroRepository livroRepository;

    public LivroService(LivroValidator livroValidator, LivroRepository livroRepository) {
        this.livroValidator = livroValidator;
        this.livroRepository = livroRepository;
    }

    public void salvarLivro(Livro livro) {
        livroValidator.validarNovoLivro(livro);
        livroRepository.save(livro);
    }

    public Optional<Livro> obterDadosLivroPorId(UUID id){
        return livroRepository.findById(id);
    }

    public void excluirLivro(Livro livro){
        livroRepository.delete(livro);
    }

    public List<Livro> pesquisa(String isbn, String titulo, String nomeAutor, GeneroLivro  genero, Integer anoPublicacao){

        Specification<Livro> livroSpecification = (root, query, cb) -> cb.conjunction();

        if (isbn != null) {
            livroSpecification = livroSpecification.and(LivroSpecs.isbnEquals(isbn));
        }
        if (titulo != null) {
            livroSpecification = livroSpecification.and(LivroSpecs.tituloLike(titulo));
        }
        if (genero != null) {
            livroSpecification = livroSpecification.and(LivroSpecs.generoIquals(genero));
        }

        List<Livro> livros = livroRepository.findAll(livroSpecification);
        return livroRepository.findAll(LivroSpecs.isbnEquals(isbn));
    }

}













