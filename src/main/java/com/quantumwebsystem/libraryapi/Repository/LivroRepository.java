package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
