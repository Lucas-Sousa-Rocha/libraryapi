package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Component;

@Component
public class AutorValidator {

    private final AutorRepository autorRepository;

    public AutorValidator(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public void validarAutor(Autor novoAutor){
        if (validaNomeAutor(novoAutor.getNome())){
            throw new IllegalArgumentException("Já existe um autor com esse nome!!");
        }
    }

    public boolean validaNomeAutor(String nomeAutor){
        return autorRepository.existsByNome(nomeAutor);
    }
}
