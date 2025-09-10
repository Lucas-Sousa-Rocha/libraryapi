package com.quantumwebsystem.libraryapi.repository;

import com.quantumwebsystem.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
