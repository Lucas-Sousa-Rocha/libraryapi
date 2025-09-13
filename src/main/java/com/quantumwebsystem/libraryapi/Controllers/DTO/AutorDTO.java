package com.quantumwebsystem.libraryapi.Controllers.DTO;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id,String nome,String nacionalidade,LocalDate dt_nascimento){}
