package com.quantumwebsystem.libraryapi.repository;

import com.quantumwebsystem.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
