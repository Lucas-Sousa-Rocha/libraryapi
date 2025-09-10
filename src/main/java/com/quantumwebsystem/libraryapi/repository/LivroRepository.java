package com.quantumwebsystem.libraryapi.repository;


import com.quantumwebsystem.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
