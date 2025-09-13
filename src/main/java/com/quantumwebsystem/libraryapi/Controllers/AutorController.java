package com.quantumwebsystem.libraryapi.Controllers;


import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> salvarAutor(@RequestBody AutorDTO autor) {

        Autor autorEntidade = autor.AutorDTO();
        autorService.salvarAutor(autorEntidade);
        URI uri = URI.create("/api/autores/" + autorEntidade.getId());
        return ResponseEntity.created(uri).body(autorEntidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obterDadosAutorPorId(@PathVariable UUID id){
        Optional<AutorDTO> autorDto = autorService.obterDadosAutorPorId(id);
        if(autorDto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorService.obterDadosAutorPorId(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable UUID id){
        Optional<AutorDTO> autorDto = autorService.obterDadosAutorPorId(id);
        if(autorDto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        autorService.excluirAutor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> obterAutores(@RequestParam(value = "nome",required = false) String nome, @RequestParam(value = "nacionalidade", required = false ) String nacionalidade){
    List<Autor> autores = autorService.buscarPorNomeENacionalidade(nome,nacionalidade);
    List<AutorDTO> autoresDTO = autores.stream().map(autor -> new AutorDTO(
            autor.getNome(),
            autor.getId(),
            autor.getNacionalidade(),
            autor.getDt_nascimento())).collect(Collectors.toList());
    return ResponseEntity.ok(autoresDTO);
    }






}
