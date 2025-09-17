package com.quantumwebsystem.libraryapi.AutorRepository;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.LivroRepository.AutorRepository;
import com.quantumwebsystem.libraryapi.LivroRepository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

   @Test
    public void saveNewAuthor(){
       Autor autor = new Autor();
       autor.setNome("Lucas Sousa");
       autor.setDtNascimento(LocalDate.of(1998, 8, 9));
       autor.setNacionalidade("Brazil");
       var authorsave = autorRepository.save(autor);
       System.out.println(authorsave);
    }

    @Test
    public void buscaInteligente(){
       List<Autor> listaAutor = autorRepository.pesquisarEmTodosOsCampos("lucas");
        listaAutor.forEach( autor -> System.out.println(autor.getNome() + " " + autor.getNacionalidade() + " " + autor.getDtNascimento()) );
    }

    @Test
    public void excluirTodosAutores(){
       autorRepository.deleteAll();
    }

    @Test
    public void excluirTodosLivros(){
       livroRepository.deleteAll();
    }
}
