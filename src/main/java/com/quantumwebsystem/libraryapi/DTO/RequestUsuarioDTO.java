package com.quantumwebsystem.libraryapi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RequestUsuarioDTO(
        @NotBlank(message = "O Campo Login Obrigatorio !!")@NotNull
        String login,
        @NotBlank(message = "O Campo Senha Obrigatorio !!")@NotNull
        String senha,
        @NotEmpty(message = "É obrigatório informar pelo menos uma role!")
        List<String> roles) {
}
