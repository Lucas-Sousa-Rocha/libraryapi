package com.quantumwebsystem.libraryapi.Repository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarBookTest() {

        Autor author = new Autor();
        author.setNome("Antonio");
        author.setNacionalidade("EUA");
        author.setDtNascimento(LocalDate.of(1980, 1, 1));
        autorRepository.save(author);


        Livro livro = new Livro();
        livro.setIsbn("59128918");
        livro.setPrice(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Book Title");
        livro.setDt_publicacao(LocalDate.of(1970, 1, 1));
        livro.setAutor(author);
        livroRepository.save(livro);

        System.out.println("Book salvo com sucesso!");
        System.out.println(livro);
    }


}