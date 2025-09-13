package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    public Autor salvarAutor(Autor autor){
            return autorRepository.save(autor);
    }

    public Optional<Autor> obterDadosAutorPorId(UUID id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return  autorRepository.findById(id);
    }

    public void excluirAutor(UUID id){
            autorRepository.deleteById(id);
        }

    public List<Autor> buscarPorNomeENacionalidade(String nome, String nacionalidade){
        return autorRepository.findByNomeAndNacionalidade(nome,nacionalidade);
    }
}
