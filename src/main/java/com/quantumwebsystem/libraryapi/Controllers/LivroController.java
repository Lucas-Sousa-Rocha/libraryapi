package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseLivroDTO;
import com.quantumwebsystem.libraryapi.Mappers.LivroMapper;
import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public ResponseEntity<Void> salvarLivro(@RequestBody @Valid RequestLivroDTO requestLivroDTO) {
            Livro livro = livroMapper.toEntity(requestLivroDTO);
            livroService.salvarLivro(livro);
            URI location = gerarHeaderLocation(livro.getId());
            return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseLivroDTO> obterDetalhesPorId(@PathVariable UUID id){
    return livroService.obterDadosLivroPorId(id).map(livro -> {var dto = livroMapper.toDTO(livro);
    return ResponseEntity.ok(dto);}).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable UUID id) {
        return livroService.obterDadosLivroPorId(id).map(livro -> {livroService.excluirLivro(livro);
            return ResponseEntity.noContent().<Void>build();}).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ResponseLivroDTO>> pesquisarPorNome(
            @RequestParam(value = "isbn",required = false)
            String isbn,
            @RequestParam(value = "titulo",required = false)
            String titulo,
            @RequestParam(value = "genero",required = false)
            GeneroLivro genero,
            @RequestParam(value = "nomeAutor",required = false)
            String nomeAutor,
            @RequestParam(value = "anoPublicacao",required = false)
            Integer anoPublicacao) {
        var resultado = livroService.pesquisa(isbn,titulo,nomeAutor,genero,anoPublicacao);
        var lista = resultado.stream().map(livroMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarLivro(@PathVariable UUID id, @RequestBody @Valid RequestLivroDTO requestLivroDTO){
       return livroService.obterDadosLivroPorId(id).map(livro -> {
           Livro entidade = livroMapper.toEntity(requestLivroDTO);
           livro.setDtPublicacao(entidade.getDtPublicacao());
           livro.setGenero(entidade.getGenero());
           livro.setIsbn(entidade.getIsbn());
           livro.setPreco(entidade.getPreco());
           livro.setTitulo(entidade.getTitulo());
           livro.setAutor(entidade.getAutor());
           livroService.atualizarLivro(livro);
           return ResponseEntity.noContent().build();
       }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}











