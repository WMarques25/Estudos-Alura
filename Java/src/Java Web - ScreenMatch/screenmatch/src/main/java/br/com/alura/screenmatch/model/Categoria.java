package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action", "Ação"),
    AVENTURA("Adventure", "Aventura"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    FICCAO("Sci-Fi", "Ficção"),
    CRIME("Crime", "Crime"),
    ROMANCE("Romance", "Romance"),
    ANIMACAO("Animation", "Animação");

    private String categoriaOmdb;
    private String categoriaPtBr;

    Categoria(String categoriaOMDB, String categoriaPTBR) {
        this.categoriaOmdb = categoriaOMDB;
        this.categoriaPtBr = categoriaPTBR;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromStringBR(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPtBr.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
