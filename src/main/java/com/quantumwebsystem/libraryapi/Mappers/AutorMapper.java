package com.quantumwebsystem.libraryapi.Mappers;

import com.quantumwebsystem.libraryapi.DTO.RequestAutorDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseAutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(RequestAutorDTO requestautorDTO);

    ResponseAutorDTO toDTO(Autor autor);

}
