package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    AVENTURA("Adventure"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    FICCAO("Sci-Fi"),
    CRIME("Crime"),
    ROMANCE("Romance"),;

    private String categoriaOmdb;

    Categoria(String categoriaOMDB) {
        this.categoriaOmdb = categoriaOMDB;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
