package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Controllers.DTO.ErroResposta;
import com.quantumwebsystem.libraryapi.Exceptions.OperacaoNaoPermitida;
import com.quantumwebsystem.libraryapi.Exceptions.ResgistroDuplicado;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> salvarAutor(@RequestBody AutorDTO autor) {
        try {
            Autor autorEntidade = autor.maperAutorDTO();
            autorService.salvarAutor(autorEntidade);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorEntidade.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (ResgistroDuplicado e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obterDadosAutorPorId(@PathVariable UUID id){
        Optional<Autor> autorOptional = autorService.obterDadosAutorPorId(id);
        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Autor autor = autorOptional.get();
        AutorDTO autorDTO = new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDtNascimento());
        return ResponseEntity.ok(autorDTO);
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
    public ResponseEntity<List<AutorDTO>> obterAutores(@RequestParam(value = "nome",required = false) String nome, @RequestParam(value = "nacionalidade", required = false ) String nacionalidade){
        List<Autor> autores = autorService.buscarPorNomeENacionalidade(nome,nacionalidade);
        List<AutorDTO> lista = autores.stream().map( autor -> new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDtNascimento()) ).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<AutorDTO>> buscaPorTodosOsCampos(@RequestParam(value = "pesquisa") String pesquisa){
        List<Autor> autores = autorService.buscaPorTodosOsCampos(pesquisa);
        List<AutorDTO> lista = autores.stream().map( autor -> new AutorDTO(autor.getId(),autor.getNome(),autor.getNacionalidade(),autor.getDtNascimento()) ).collect(Collectors.toList());
    return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarAutor(@PathVariable(value = "id") UUID id, @RequestBody AutorDTO autorDto){
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
