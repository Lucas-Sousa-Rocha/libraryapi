package com.quantumwebsystem.libraryapi.LivroRepository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import com.quantumwebsystem.libraryapi.Service.AutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    AutorService autorService;

    @Test
    void salvarLivroEAutor() {

        Autor author = new Autor();
        author.setNome("Antonio");
        author.setNacionalidade("EUA");
        author.setDtNascimento(LocalDate.of(1980, 1, 1));
        autorRepository.save(author);


        Livro livro = new Livro();
        livro.setIsbn("59128918");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Book Title");
        livro.setDtPublicacao(LocalDate.of(1970, 1, 1));
        livro.setAutor(author);
        livroRepository.save(livro);

        System.out.println("Book salvo com sucesso!");
        System.out.println(livro);
    }

    @Test
    public void salvarLivro(){
     Livro livro = new Livro();
     Autor autor = new Autor();
     autor.setId(UUID.fromString("06172c1a-d302-486a-ae9d-7ef34d920dbb"));
     livro.setIsbn("59128918");
     livro.setPreco(BigDecimal.valueOf(100));
     livro.setGenero(GeneroLivro.BIOGRAFIA);
     livro.setTitulo("Book Title");
     livro.setDtPublicacao(LocalDate.of(1970, 1, 1));
     livro.setAutor(autor);
     livroRepository.save(livro);
    }

    @Test
    public void salvarAutor(){
        Autor autor = new Autor();
        autor.setNome("Antonio");
        autor.setNacionalidade("EUA");
        autor.setDtNascimento(LocalDate.of(1980, 1, 1));
        autorService.salvarAutor(autor);
    }


}