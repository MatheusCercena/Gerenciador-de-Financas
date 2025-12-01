package model;

import java.sql.Date;

public class Transacao {
    private int id;
    private int idUsuario;
    private Tipo tipo;
    private Categoria categoria;
    private Origem origem;
    private double valor;
    private Date data;

    public Transacao(int id, int idUsuario, Tipo tipo, Categoria categoria, Origem origem, double valor, Date data) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.categoria = categoria;
        this.origem = origem;
        this.valor = valor;
        this.data = data;
    }

    public Transacao(int idUsuario, Tipo tipo, Categoria categoria, Origem origem, double valor, Date data) {
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.origem = origem;
        this.valor = valor;
        this.data = data;
    }

    public Transacao() {
    }

    private int gerarId(){
        return 0;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
