package br.com.desafio.musicas.model;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private Long id;
    private String nome;
    private Categoria categoria;
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {}

    public Artista(String nome, String categoria) {
        this.nome = nome;
        this.categoria = Categoria.fromPortugues(categoria);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setArtista(this));
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Artista: " + nome +
                " - Categoria: "  + categoria;
    }
}
