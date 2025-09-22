package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }


}
