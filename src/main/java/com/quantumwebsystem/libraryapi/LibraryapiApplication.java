package com.quantumwebsystem.libraryapi;

import com.quantumwebsystem.libraryapi.model.Author;
import com.quantumwebsystem.libraryapi.repository.AuthorRepository;
import com.quantumwebsystem.libraryapi.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryapiApplication.class, args);
    }
}
