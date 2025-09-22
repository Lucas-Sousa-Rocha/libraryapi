package com.quantumwebsystem.libraryapi.Controllers;



import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseLivroDTO;
import com.quantumwebsystem.libraryapi.Mappers.LivroMapper;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;
    private final LivroMapper livroMapper;

    public LivroController(LivroService livroService, LivroMapper livroMapper) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
    }

    @PostMapping
    public ResponseEntity<Object> salvarLivro(@RequestBody @Valid RequestLivroDTO requestlivroDTO) {
        try {
            Livro livro = livroService.salvar(requestlivroDTO);
            ResponseLivroDTO resposta = livroMapper.toDTO(livro);
            return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", e.getMessage()));
        }
    }

}
