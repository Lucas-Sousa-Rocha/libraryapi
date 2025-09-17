package com.quantumwebsystem.libraryapi.Controllers.DTO;

import com.quantumwebsystem.libraryapi.Model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,
        @NotBlank(message = "Campo Obrigatorio !!")
        String nome,
        @NotBlank(message = "Campo Obrigatorio !!")
        String nacionalidade,
        @NotNull
        LocalDate dtNascimento){

    public Autor maperAutorDTO() {
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setDtNascimento(dtNascimento);
        return autor;
    }
}
