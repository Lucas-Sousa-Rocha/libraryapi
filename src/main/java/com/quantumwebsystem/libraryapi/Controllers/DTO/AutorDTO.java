package com.quantumwebsystem.libraryapi.Controllers.DTO;

import com.quantumwebsystem.libraryapi.Model.Autor;
import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id,String nome,String nacionalidade,LocalDate dt_nascimento){

    public Autor maperAutorDTO() {
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setDt_nascimento(dt_nascimento);
        return autor;
    }
}
