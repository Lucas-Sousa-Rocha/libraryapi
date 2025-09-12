package com.quantumwebsystem.libraryapi.Controllers;


import com.quantumwebsystem.libraryapi.Controllers.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> salvarAutor(@RequestBody AutorDTO autorDTO) {
        AutorDTO autorDto = autorService.salvarAutor(autorDTO);
        URI uri = URI.create("/api/autores/" + autorDto.getId());
        return ResponseEntity.created(uri).body(autorDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obterDadosAutorPorId(@PathVariable UUID id){
        Optional<AutorDTO> autor = autorService.obterDadosAutorPorId(id);
        if(autor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorService.obterDadosAutorPorId(id).orElse(null));
    }

}
