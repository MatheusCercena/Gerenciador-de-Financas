package Model;

import Model.Categoria;
import Model.Origem;

import java.util.Date;

public class Transacao {
    private int id;
    private Tipo tipo;
    private Categoria categoria;
    private Origem origem;
    private double valor;
    private Date data;

    public Transacao(Origem origem, Categoria categoria, Tipo tipo, Date data, double valor) {
        this.id = gerarId();
        this.origem = origem;
        this.categoria = categoria;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public Transacao(double valor, Date data, Tipo tipo, Categoria categoria, Origem origem, String observacoes) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
        this.origem = origem;
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

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

}
