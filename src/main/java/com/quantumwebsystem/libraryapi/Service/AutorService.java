package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    public AutorDTO salvarAutor(AutorDTO autorDTO){
        Autor autor = new Autor();
        autor.setNome(autorDTO.getNome());
        autor.setNacionalidade(autorDTO.getNacionalidade());
        autor.setDt_nascimento(autorDTO.getDt_nascimento());

        var autorsave = autorRepository.save(autor);

        AutorDTO resposta = new AutorDTO();
        resposta.setId(autorsave.getId());
        resposta.setNome(autorsave.getNome());
        resposta.setNacionalidade(autorsave.getNacionalidade());
        resposta.setDt_nascimento(autorsave.getDt_nascimento());
        return resposta;
    }

}
