package com.quantumwebsystem.libraryapi.Common;


import com.quantumwebsystem.libraryapi.DTO.ErroCampo;
import com.quantumwebsystem.libraryapi.DTO.ErroResposta;
import com.quantumwebsystem.libraryapi.Exceptions.AutorNaoEncontrado;
import com.quantumwebsystem.libraryapi.Exceptions.OperacaoNaoPermitida;
import com.quantumwebsystem.libraryapi.Exceptions.RegraNegocio;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidExeption(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> listaErros = fieldErrors.stream().map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage())).collect(Collectors.toList());
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(),"Erro de validação",listaErros);
    }

    @ExceptionHandler(ResgistroDuplicado.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleRegistroDuplicado(ResgistroDuplicado e){
        return ErroResposta.conflito(e.getMessage());
    }

    @ExceptionHandler(AutorNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta handleAutorNaoEncontrado(AutorNaoEncontrado e){
        return ErroResposta.naoEncontrado(e.getMessage());
    }

    @ExceptionHandler(OperacaoNaoPermitida.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleOperacaoNaoPermitida(OperacaoNaoPermitida e){
        return ErroResposta.respostaPadrao(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResposta handleGenerico(RuntimeException e){
        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Erro interno !!",List.of());
    }

    @ExceptionHandler(RegraNegocio.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleRegraNegocio(RegraNegocio e){
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação",List.of(new ErroCampo(e.getCampo(),e.getMessage())));
    }


}
