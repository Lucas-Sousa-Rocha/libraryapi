package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AutorValidator {

    private final AutorRepository autorRepository;

    public AutorValidator(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public void validarAutor(Autor novoAutor) {
        if (autorExiste(novoAutor)){
            throw new ResgistroDuplicado("Autor já cadastrado !!");
        }
    }

    private boolean autorExiste(Autor novoAutor){
        Optional<Autor> autorEncontrado = autorRepository.findByNomeIgnoreCaseAndNacionalidadeIgnoreCaseAndDtNascimento(novoAutor.getNome().trim(),novoAutor.getNacionalidade().trim(),novoAutor.getDtNascimento());
        if (novoAutor.getId() == null){
            return autorEncontrado.isPresent();
        }
        if (autorEncontrado.isEmpty()) {
            return false;
        }
        return !novoAutor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }

}
