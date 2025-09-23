package com.quantumwebsystem.libraryapi.Mappers;

import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.DTO.ResponseLivroDTO;
import com.quantumwebsystem.libraryapi.Exceptions.AutorNaoEncontrado;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public abstract class LivroMapper {

    @Autowired
    protected AutorRepository autorRepository;

    public Livro toEntity(RequestLivroDTO dto) {
        Livro livro = new Livro();
        livro.setIsbn(dto.isbn());
        livro.setTitulo(dto.titulo());
        livro.setDtPublicacao(dto.dtPublicacao());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());
        Autor autor = autorRepository.findById(dto.idAutor()).orElseThrow(() -> new AutorNaoEncontrado("Autor não encontrado!!"));
        livro.setAutor(autor);
        return livro;
    }

    public abstract ResponseLivroDTO toDTO(Livro livro);

}

