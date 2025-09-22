package com.quantumwebsystem.libraryapi.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseAutorDTO(
        UUID id,
        String nome,
        String nacionalidade,
        LocalDate dtNascimento
) {
}
