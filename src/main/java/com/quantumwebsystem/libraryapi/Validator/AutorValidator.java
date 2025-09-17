package com.quantumwebsystem.libraryapi.Validator;

import com.quantumwebsystem.libraryapi.Exceptions.OperacaoNaoPermitida;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
public class AutorValidator {

    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    public AutorValidator(AutorRepository autorRepository, LivroRepository livroRepository){
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
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

    public void validarSeAutorPussuilivros(UUID id){
        if (autorPossuiLivros(id)){
            throw new OperacaoNaoPermitida("Autor possui livros !");
        }
    }

    private boolean autorPossuiLivros(UUID id){
        return livroRepository.existsLivroByAutorId(id);
    }

}
