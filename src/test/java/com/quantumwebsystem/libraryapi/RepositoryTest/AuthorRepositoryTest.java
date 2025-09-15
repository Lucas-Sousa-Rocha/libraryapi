package com.quantumwebsystem.libraryapi.RepositoryTest;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
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
       autor.setDt_nascimento(LocalDate.of(1998, 8, 9));
       autor.setNacionalidade("Brazil");
       var authorsave = autorRepository.save(autor);
       System.out.println(authorsave);
    }

    @Test
    public void testeQuery(){
    List<Autor> list = autorRepository.todosAutoresQueryNativa();
    //System.out.printf(list.toString());
    for(Autor autor : list){
        System.out.println(autor.getNome());
    }
    }


}
