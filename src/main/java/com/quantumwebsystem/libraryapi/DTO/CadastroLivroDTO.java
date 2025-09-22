package com.quantumwebsystem.libraryapi.DTO;

import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(
        @ISBN(message = "O Campo ISBN é Inválido")
        @NotBlank(message = "O Campo ISBN é Obrigatorio !!")
        String isbn,
        @NotBlank(message = "O Campo Título é Obrigatorio !!")
        String titulo,
        @Past(message = "Não Pode Ser Uma Data Futura !!")
        @NotNull(message = "O Campo Data de Publicação Obrigatorio !!")
        LocalDate dtPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        @NotNull(message = "O Campo ID Autor é Obrigatorio !!")
        UUID autorId
        ) {
}
