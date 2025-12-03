package model;

import java.sql.Date;

public class Transacao {
    private int id;
    private Tipo tipo;
    private Categoria categoria;
    private Origem origem;
    private double valor;
    private Date data;
    private String observacoes;

    public Transacao(int id, Tipo tipo, Categoria categoria, Origem origem, double valor, Date data, String observacoes) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.origem = origem;
        this.valor = valor;
        this.data = data;
        this.observacoes = observacoes;
    }

    public Transacao(Tipo tipo, Categoria categoria, Origem origem, double valor, Date data, String observacoes) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.origem = origem;
        this.valor = valor;
        this.data = data;
        this.observacoes = observacoes;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
