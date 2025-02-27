package com.example.blockbuster.controllers;

import com.example.blockbuster.models.Filme;
import com.example.blockbuster.services.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")

public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController (FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<Filme> listarFilmes(){
        return  filmeService.listarTodos();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Filme> buscarFilme(@PathVariable Long id){
        Optional<Filme> filme = filmeService.buscarPorId(id);
        return filme.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme){
        return filmeService.salvar(filme);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme
            novoFilme) {
        return filmeService.buscarPorId(id)
                .map(filmeExistente -> {
                    filmeExistente.setNome(novoFilme.getNome());
                    filmeExistente.setAnoLancamento(novoFilme.getAnoLancamento());
                    filmeExistente.setGenero(novoFilme.getGenero());
                    return ResponseEntity.ok(filmeService.salvar(filmeExistente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        if (filmeService.buscarPorId(id).isPresent()) {
            filmeService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
