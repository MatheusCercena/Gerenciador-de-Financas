package model;

import java.util.Objects;

public class Origem {
    private int id;
    private String nome;

    public Origem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Origem() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Origem origem = (Origem) o;
        return id == origem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Origem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

