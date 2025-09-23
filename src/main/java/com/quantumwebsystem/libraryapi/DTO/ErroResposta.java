package com.quantumwebsystem.libraryapi.DTO;

import org.springframework.http.HttpStatus;
import java.util.List;

public record ErroResposta(int status, String mensagem, List<ErroCampo> erros) {

    public static ErroResposta respostaPadrao(String mensagem) {
        return new ErroResposta(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
    }

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }

    public static ErroResposta naoEncontrado(String mensagem) {
        return new ErroResposta(HttpStatus.NOT_FOUND.value(), mensagem, List.of());
    }

    public static ErroResposta erroInterno(String mensagem) {
        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem, List.of());
    }

}
