package com.quantumwebsystem.libraryapi.Mappers;

import com.quantumwebsystem.libraryapi.DTO.RequestUsuarioDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseUsuarioDTO;
import com.quantumwebsystem.libraryapi.Model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(RequestUsuarioDTO requestUsuarioDTO);

    ResponseUsuarioDTO toDTO(Usuario usuario);
}