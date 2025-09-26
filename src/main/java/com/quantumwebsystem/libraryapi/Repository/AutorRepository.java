package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {

    @Query("""
            SELECT a FROM Autor a
    WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :pesquisa, '%'))
       OR LOWER(a.nacionalidade) LIKE LOWER(CONCAT('%', :pesquisa, '%'))
       OR CAST(FUNCTION('TO_CHAR', a.dtNascimento, 'DDMMYYYY') AS string) LIKE CONCAT('%', :pesquisa, '%')""")
    List<Autor> pesquisarEmTodosOsCampos(@Param("pesquisa") String pesquisa);

    List<Autor> findByNomeContainingAndNacionalidadeContaining(String nome, String nacionalidade);

    Optional<Autor> findByNomeIgnoreCaseAndNacionalidadeIgnoreCaseAndDtNascimento(String nome, String nacionalidade, LocalDate dtNascimento);

}
