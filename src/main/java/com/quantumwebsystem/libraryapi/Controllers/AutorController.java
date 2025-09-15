package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
    public ResponseEntity<Void> salvarAutor(@RequestBody AutorDTO autor, Errors errors) {
        try {
            Autor autorEntidade = autor.maperAutorDTO();
            autorService.salvarAutor(autorEntidade);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorEntidade.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obterDadosAutorPorId(@PathVariable UUID id){
        Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Autor autor = autorOptional.get();
        AutorDTO autorDTO = new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDt_nascimento());
        return ResponseEntity.ok(autorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable UUID id){
        Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        autorService.excluirAutor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> obterAutores(@RequestParam(value = "nome",required = false) String nome, @RequestParam(value = "nacionalidade", required = false ) String nacionalidade){
        List<Autor> autores = autorService.buscarPorNomeENacionalidade(nome,nacionalidade);
        List<AutorDTO> lista = autores.stream().map( autor -> new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDt_nascimento()) ).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<AutorDTO>> buscaPorTodosOsCampos(@RequestParam(value = "pesquisa") String pesquisa){
        List<Autor> autores = autorService.buscaPorTodosOsCampos(pesquisa);
        List<AutorDTO> lista = autores.stream().map( autor -> new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDt_nascimento()) ).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarAutor(@PathVariable(value = "id") UUID id, @RequestBody AutorDTO autorDto){
        Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Autor autor = autorOptional.get();
        autor.setNome(autorDto.nome());
        autor.setNacionalidade(autorDto.nacionalidade());
        autor.setDt_nascimento(autorDto.dt_nascimento());
        autorService.editarAutor(autor);
        return ResponseEntity.noContent().build();
    }

}
