package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.DTO.ErroResposta;
import com.quantumwebsystem.libraryapi.DTO.RequestAutorDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseAutorDTO;
import com.quantumwebsystem.libraryapi.Exceptions.OperacaoNaoPermitida;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Mappers.AutorMapper;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/autores")
public class AutorController implements GenericController{

    private final AutorService autorService;
    private final AutorMapper autorMapper;

    public AutorController(AutorService autorService, AutorMapper autorMapper) {
        this.autorService = autorService;
        this.autorMapper = autorMapper;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAutor(@RequestBody @Valid RequestAutorDTO autorDTO) {
        try {
            Autor autor = autorMapper.toEntity(autorDTO);
            autorService.salvarAutor(autor);
            URI location = gerarHeaderLocation(autor.getId());
            return ResponseEntity.created(location).build();
        } catch (ResgistroDuplicado e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAutorDTO> obterDadosAutorPorId(@PathVariable UUID id){
        return autorService.obterDadosAutorPorId(id).map(autor -> {ResponseAutorDTO autorDTO = autorMapper.toDTO(autor);
            return ResponseEntity.ok(autorDTO);}).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirAutor(@PathVariable UUID id){
        try {
            Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
            if (autorOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            autorService.excluirAutor(id);
            return ResponseEntity.noContent().build();
        } catch (OperacaoNaoPermitida e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping
    public ResponseEntity<List<ResponseAutorDTO>> obterAutores(@RequestParam(value = "nome",required = false) String nome, @RequestParam(value = "nacionalidade", required = false ) String nacionalidade){
        List<Autor> autores = autorService.pesquisarByExemple(nome,nacionalidade);
        List<ResponseAutorDTO> lista = autores.stream().map(autorMapper::toDTO).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<ResponseAutorDTO>> buscaPorTodosOsCampos(@RequestParam(value = "pesquisa") String pesquisa) {
    List<Autor> autores = autorService.buscaPorTodosOsCampos(pesquisa);
    List<ResponseAutorDTO> lista = autores.stream().map(autor -> new ResponseAutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDtNascimento())).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarAutor(@PathVariable(value = "id") UUID id, @RequestBody @Valid ResponseAutorDTO autorDto){
        try {
            Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
            if (autorOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Autor autor = autorOptional.get();
            autor.setNome(autorDto.nome());
            autor.setNacionalidade(autorDto.nacionalidade());
            autor.setDtNascimento(autorDto.dtNascimento());
            autorService.editarAutor(autor);
            return ResponseEntity.noContent().build();
        } catch (ResgistroDuplicado e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

}
