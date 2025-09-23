package com.quantumwebsystem.libraryapi.DTO;

import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ResponseLivroDTO(
        UUID id,
        String isbn,
        String titulo,
        LocalDate dtPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        RequestAutorDTO autor
) {}
