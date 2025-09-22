package com.quantumwebsystem.libraryapi.Mappers;

import com.quantumwebsystem.libraryapi.DTO.RequestAutorDTO;
import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseLivroDTO;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    // DTO de entrada → Entity
    @Mapping(target = "autor", ignore = true) // será setado no service
    Livro toEntity(RequestLivroDTO requestlivroDTO);

    // Entity → DTO de saída (LivroDTO com AutorDTO)
    @Mapping(source = "autor", target = "autor")
    ResponseLivroDTO toDTO(Livro livro);

    // Autor → AutorDTO
    RequestAutorDTO autorToDTO(Autor autor);
}
