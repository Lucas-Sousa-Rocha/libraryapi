package com.quantumwebsystem.libraryapi.Mappers;

import com.quantumwebsystem.libraryapi.DTO.AutorDTO;
import com.quantumwebsystem.libraryapi.Model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorDTO autorDTO);

    AutorDTO toDTO(Autor autor);

}
