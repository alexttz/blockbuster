package com.example.blockbuster.services;

import com.example.blockbuster.models.Filme;
import com.example.blockbuster.repositories.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService (FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id){
        return filmeRepository.findById(id);
    }

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletar(Long id){
        filmeRepository.deleteById(id);
    }

}
