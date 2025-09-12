package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public Optional<AutorDTO> obterDadosAutorPorId(UUID id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            AutorDTO autorDTO = new AutorDTO();
            autorDTO.setId(autor.get().getId());
            autorDTO.setNome(autor.get().getNome());
            autorDTO.setNacionalidade(autor.get().getNacionalidade());
            autorDTO.setDt_nascimento(autor.get().getDt_nascimento());
            return Optional.of(autorDTO);
        }
        return Optional.empty();
    }

}
