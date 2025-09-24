package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.Exceptions.RegraNegocio;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class LivroValidator {

    private static final int MAX_ANO_PUBLICACAO = 2020;

    private final LivroRepository livroRepository;

    public LivroValidator(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public void validarLivro(Livro livro) {
        if (existeLivroComIsbn(livro)){
            throw new ResgistroDuplicado("Já existe um livro com este ISBN!");
        }
        if (precoObrigatorioNulo(livro)){
            throw new RegraNegocio("preço","Para livros com ano de publicação anterior a 2020 é obrigatorio o preço !!");
        }
    }

    private boolean precoObrigatorioNulo(Livro livro) {
        return livro.getPreco() == null && livro.getDtPublicacao().getYear() < MAX_ANO_PUBLICACAO;
    }

    public boolean existeLivroComIsbn(Livro livro){
        Optional<Livro> livroEncontrado = livroRepository.findByIsbn(livro.getIsbn());
        if(livro.getId() == null){
            return livroEncontrado.isPresent();
        }
        return !livro.getId().equals(livroEncontrado.get().getId()) && livroEncontrado.isPresent();
    }
}
