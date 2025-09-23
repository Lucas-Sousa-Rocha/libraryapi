package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.DTO.ErroResposta;
import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.Exceptions.AutorNaoEncontrado;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Mappers.LivroMapper;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@RequestMapping("/api/livros")
public class LivroController implements GenericController{

    private final LivroService livroService;
    private final LivroMapper livroMapper;

    public LivroController(LivroService livroService, LivroMapper livroMapper) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
    }

    @PostMapping
    public ResponseEntity<Object> salvarLivro(@RequestBody @Valid RequestLivroDTO requestLivroDTO) {
        try {
            Livro livro = livroMapper.toEntity(requestLivroDTO);
            livroService.salvarLivro(livro);
            URI location = gerarHeaderLocation(livro.getId());
            return ResponseEntity.created(location).build();
        } catch (AutorNaoEncontrado e) {
            var erroDTO = ErroResposta.naoEncontrado(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        } catch (ResgistroDuplicado e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

}
