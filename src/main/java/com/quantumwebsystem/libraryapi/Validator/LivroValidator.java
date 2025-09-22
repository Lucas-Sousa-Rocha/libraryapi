package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LivroValidator {

    private final LivroRepository livroRepository;

    public LivroValidator(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public void validarLivro(Livro novoLivro) {
        Optional<Livro> livroEncontrado = livroRepository.findByIsbnIgnoreCaseAndTituloIgnoreCase(novoLivro.getIsbn().trim(), novoLivro.getTitulo().trim());

    }
}
