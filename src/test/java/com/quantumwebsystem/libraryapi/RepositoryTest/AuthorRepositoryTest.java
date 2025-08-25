package com.quantumwebsystem.libraryapi.RepositoryTest;

import com.quantumwebsystem.libraryapi.model.Author;
import com.quantumwebsystem.libraryapi.repository.AuthorRepository;
import com.quantumwebsystem.libraryapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;



   @Test
    public void saveNewAuthor(){
        Author author = new Author();
        author.setName("Lucas Sousa");
        author.setDt_birth(LocalDate.of(1998, 8, 9));
        author.setNationality("Brazil");
        var authorsave = authorRepository.save(author);
        System.out.println(authorsave);
    }


}
