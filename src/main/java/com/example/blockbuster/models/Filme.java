package com.example.blockbuster.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="Filmes")

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String genero;
    private int anoLancamento;

    public Filme(String nome, String genero, int anoLancamento) {

        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
