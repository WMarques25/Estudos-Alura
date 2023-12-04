package br.com.alura.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaID id;

    public Categoria() {}
    public Categoria(String nome) {
        this.id = new CategoriaID(nome, "xpto");
    }

    public String getNome() {
        return this.id.getNome();
    }
}
