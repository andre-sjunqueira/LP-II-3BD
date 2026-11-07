package edu.fatec.lp2.exercicio2.compra;

/**
 * Interface comum a ItemCompra e ListaCompra:
 * tudo que é "Calculavel" sabe informar o próprio preço.
 */
public interface Calculavel {

    double calcularPreco();
}
