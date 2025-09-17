package com.quantumwebsystem.libraryapi.Controllers.DTO;

import com.quantumwebsystem.libraryapi.Model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,
        @NotBlank(message = "Campo Obrigatorio !!")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres !!")
        String nome,
        @NotBlank(message = "Campo Obrigatorio !!")
        @Size(min = 3, max = 10, message = "A nacionalidade deve ter entre 3 e 10 caracteres !!")
        String nacionalidade,
        @NotNull
        @Past(message = "Não pode ser uma data futura")
        LocalDate dtNascimento){

    public Autor maperAutorDTO() {
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setDtNascimento(dtNascimento);
        return autor;
    }
}
