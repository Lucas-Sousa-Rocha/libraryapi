package com.quantumwebsystem.libraryapi.LivroRepository;

import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    boolean existsLivroByAutorId(UUID id);

    boolean existsByIsbnIgnoreCase(String isbn);

    boolean existsByTituloIgnoreCase(String titulo);

    Optional<Livro> findById(UUID id);
}
