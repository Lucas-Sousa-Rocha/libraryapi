package com.quantumwebsystem.libraryapi.Repository.Specs;

import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecs {

    public static Specification<Livro> isbnEquals(String isbn){
        return (root, query, cb) -> cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Livro> tituloLike(String titulo){
        return (root, query, cb) -> cb.equal(cb.upper(root.get("titulo")), "%"+titulo.toUpperCase()+"%");
    }

    public static Specification<Livro> generoIquals(GeneroLivro  genero){
        return (root, query, cb) -> cb.equal(root.get("genero"), genero);
    }
}
