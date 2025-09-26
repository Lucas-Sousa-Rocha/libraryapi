package com.quantumwebsystem.libraryapi.Security;

import com.quantumwebsystem.libraryapi.Model.Usuario;
import com.quantumwebsystem.libraryapi.Service.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    private final UsuarioService usuarioService;
    public SecurityService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    public Usuario obterusuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return usuarioService.obterPorLogin(userDetails.getUsername());
    }





}
