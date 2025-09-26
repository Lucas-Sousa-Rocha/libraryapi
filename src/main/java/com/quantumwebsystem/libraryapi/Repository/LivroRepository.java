package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro> {

    boolean existsLivroByAutorId(UUID id);

    Optional<Livro> findById(UUID id);

    Optional<Livro> findByIsbn(String isbn);

}
