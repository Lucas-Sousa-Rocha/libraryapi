package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
