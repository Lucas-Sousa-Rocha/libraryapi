package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
    List<Autor> findByNomeContainingAndNacionalidadeContaining(String nome, String nacionalidade);

    @Query("SELECT a FROM Autor a " +
            "WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :pesquisa, '%')) " +
            "   OR LOWER(a.nacionalidade) LIKE LOWER(CONCAT('%', :pesquisa, '%')) " +
            "   OR CAST(a.dt_nascimento AS string) LIKE CONCAT('%', :pesquisa, '%')")
    List<Autor> pesquisarEmTodosOsCampos(@Param("pesquisa") String pesquisa);

    boolean existsByNome(String nome);
}
