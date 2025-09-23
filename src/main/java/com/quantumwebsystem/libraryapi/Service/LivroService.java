package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Validator.LivroValidator;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroValidator livroValidator;
    private final LivroRepository livroRepository;

    public LivroService(LivroValidator livroValidator, LivroRepository livroRepository) {
        this.livroValidator = livroValidator;
        this.livroRepository = livroRepository;
    }

    public void salvarLivro(Livro livro) {
        livroValidator.validarLivro(livro);
        livroRepository.save(livro);
    }

}
