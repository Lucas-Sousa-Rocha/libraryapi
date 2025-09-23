package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.Exceptions.AutorNaoEncontrado;
import com.quantumwebsystem.libraryapi.Exceptions.OperacaoNaoPermitida;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.LivroRepository.AutorRepository;
import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class LivroValidator {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroValidator(LivroRepository livroRepository, AutorRepository autorRepository){
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void validarNovoLivro(Livro livro) {
        validarAutor(livro.getAutor().getId());
        validarIsbn(livro.getIsbn());
        validarTitulo(livro.getTitulo());
    }

    private void validarAutor(UUID idAutor) {
        if (!autorRepository.existsById(idAutor)) {
            throw new AutorNaoEncontrado("Autor não encontrado!");
        }
    }

    private void validarIsbn(String isbn) {
        if (livroRepository.existsByIsbnIgnoreCase(isbn)) {
            throw new ResgistroDuplicado("Já existe um livro com este ISBN!");
        }
    }

    private void validarTitulo(String titulo) {
        if (livroRepository.existsByTituloIgnoreCase(titulo)) {
            throw new ResgistroDuplicado("Já existe um livro com este título!");
        }
    }

    public void validarParaExcluir(UUID id){
        if (!livroRepository.existsById(id)){
            throw new OperacaoNaoPermitida("Livro não existe !!");
        }
    }

}
