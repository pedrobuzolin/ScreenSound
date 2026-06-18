package br.com.desafio.musicas.model;

public enum Categoria {
    SOLO ("solo"),
    DUPLA ("dupla"),
    BANDA ("banda");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public static Categoria fromPortugues(String texto) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.descricao.equalsIgnoreCase(texto)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontra para a string fornecida!");
    }
}
