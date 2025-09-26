package com.quantumwebsystem.libraryapi.DTO;

import java.util.List;

public record ResponseUsuarioDTO(
        String login,
        String nome,
        List<String> roles) {
}
