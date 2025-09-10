package com.quantumwebsystem.libraryapi.repository;

import com.quantumwebsystem.libraryapi.model.Author;
import com.quantumwebsystem.libraryapi.model.Book;
import com.quantumwebsystem.libraryapi.model.GenderBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void salvarBookTest() {

        Author author = new Author();
        author.setName("Antonio");
        author.setNationality("EUA");
        author.setDt_birth(LocalDate.of(1980, 1, 1));
        //authorRepository.save(author);


        Book book = new Book();
        book.setIsbn("59128918");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGender(GenderBook.BIOGRAFIA);
        book.setTitle("Book Title");
        book.setDt_publication(LocalDate.of(1970, 1, 1));
        book.setAuthor(author);
        bookRepository.save(book);

        System.out.println("Book salvo com sucesso!");
        System.out.println(book);


    }



}