package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Validator.LivroValidator;
import org.springframework.stereotype.Service;
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

}
