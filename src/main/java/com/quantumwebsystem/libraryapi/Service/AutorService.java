package com.quantumwebsystem.libraryapi.Service;

import com.quantumwebsystem.libraryapi.Model.Autor;
import com.quantumwebsystem.libraryapi.Repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void salvarAutor(Autor autor){
        autorRepository.save(autor);
    }

    public Optional<Autor> obterDadosAutorPorId(UUID id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return  autorRepository.findById(id);
    }

    public void excluirAutor(UUID id){
            autorRepository.deleteById(id);
        }

    public List<Autor> buscarPorNomeENacionalidade(String nome, String nacionalidade){
        return autorRepository.findByNomeContainingAndNacionalidadeContaining(nome,nacionalidade);
    }

    public List<Autor> buscaPorTodosOsCampos(String pesquisa){
        return autorRepository.pesquisarEmTodosOsCampos(pesquisa);
    }

    public void editarAutor(Autor autor) {
        if(autor.getId() == null){
            throw new IllegalArgumentException("Erro, para editar o autor deve existir !!");
        }
        autorRepository.save(autor);
    }
}
