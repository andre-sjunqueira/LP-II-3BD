package edu.fatec.lp2.exercicio2.modelo;

/**
 * Abstração simplificada do supermercado: só o nome.
 */
public class Supermercado {

    private String nome;

    public Supermercado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
