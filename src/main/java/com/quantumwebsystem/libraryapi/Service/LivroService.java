package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.DTO.RequestLivroDTO;
import com.quantumwebsystem.libraryapi.LivroRepository.AutorRepository;
import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import com.quantumwebsystem.libraryapi.Mappers.LivroMapper;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Validator.AutorValidator;
import com.quantumwebsystem.libraryapi.Validator.LivroValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final LivroMapper livroMapper;
    private final LivroValidator livroValidator;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository, LivroMapper livroMapper, LivroValidator livroValidator){
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.livroMapper = livroMapper;
        this.livroValidator = livroValidator;
    }

    @Transactional
    public Livro salvar(RequestLivroDTO dto) {
        Livro livro = livroMapper.toEntity(dto);
        livroValidator.validarLivro(livro);
        Autor autor = autorRepository.findById(dto.idAutor()).orElseThrow(() -> new IllegalArgumentException("Autor não encontrado"));
        livro.setAutor(autor);
        return livroRepository.save(livro);
    }

}
