package com.quantumwebsystem.libraryapi.AutorRepository;


import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import com.quantumwebsystem.libraryapi.Repository.LivroRepository;
import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Service.AutorService;
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
    @Autowired
    private AutorService autorService;

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

    @Test
    public void validarPesquisaByExemple(){
    List<Autor> listaAutor =  autorService.pesquisarByExemple("","Russo");
    if (listaAutor.isEmpty()){
        System.out.println("Nenhum resultado encontrado!!");
    }
    listaAutor.forEach(autor ->  System.out.println("Nome Autor: "+autor.getNome() + "\n" + "Nacionalidade: "+autor.getNacionalidade()));
    }
}
