package com.quantumwebsystem.libraryapi.Controllers;

import com.quantumwebsystem.libraryapi.DTO.RequestUsuarioDTO;
import com.quantumwebsystem.libraryapi.Mappers.UsuarioMapper;
import com.quantumwebsystem.libraryapi.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;


    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarUsuario(@RequestBody RequestUsuarioDTO usuarioDTO){
        var usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioService.salvarUsuario(usuario);
    }
}
