package com.quantumwebsystem.libraryapi.Repository.Specs;

import com.quantumwebsystem.libraryapi.Model.GeneroLivro;
import com.quantumwebsystem.libraryapi.Model.Livro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecs {

    public static Specification<Livro> isbnEquals(String isbn) {
        return (root, query, cb) ->
                cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Livro> tituloLike(String titulo) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
    }

    public static Specification<Livro> autorNomeLike(String nomeAutor) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.join("autor").get("nome")), "%" + nomeAutor.toLowerCase() + "%");
    }

    public static Specification<Livro> generoEquals(GeneroLivro genero) {
        return (root, query, cb) ->
                cb.equal(root.get("genero"), genero);
    }

    public static Specification<Livro> anoPublicacaoEquals(Integer anoPublicacao) {
        return (root, query, cb) ->
                cb.equal(cb.function("to_char", String.class, root.get("dtPublicacao"), cb.literal("YYYY")),anoPublicacao.toString());
    }

}








































