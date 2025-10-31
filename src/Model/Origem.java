package Model;

public class Origem {
    private int id;
    private String nome;

    public Origem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Origem() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

