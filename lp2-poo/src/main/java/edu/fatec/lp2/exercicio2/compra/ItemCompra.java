package edu.fatec.lp2.exercicio2.compra;

import edu.fatec.lp2.exercicio2.modelo.Produto;

/**
 * Item de compra: UM produto, a quantidade comprada e o desconto aplicado.
 * O desconto é percentual (10 = 10%) e vai de 0 até o descontoMaximo do produto.
 */
public class ItemCompra implements Calculavel {

    private int quantidade;
    private Produto produto;   // um único produto por item
    private double desconto;   // percentual

    /** Construtor do diagrama. Como ele não recebe a quantidade, ela começa em 1. */
    public ItemCompra(Produto produto, double desconto) {
        this(produto, 1, desconto);
    }

    /** Acréscimo ao diagrama: construtor que já recebe a quantidade. */
    public ItemCompra(Produto produto, int quantidade, double desconto) {
        setProduto(produto);
        setQuantidade(quantidade);
        setDesconto(desconto);
    }

    /** Preço do item, independente dos demais: preço x quantidade, menos o desconto. */
    @Override
    public double calcularPreco() {
        double bruto = produto.getPreco() * quantidade;
        return bruto * (1 - desconto / 100);
    }

    @Override
    public String toString() {
        return String.format("%dx %s (%s) - R$ %.2f cada, %.0f%% de desconto = R$ %.2f",
                quantidade, produto, produto.getUnidade(), produto.getPreco(), desconto, calcularPreco());
    }

    // ===== Getters e setters =====

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    /**
     * Troca o produto do item (continua sendo um só).
     * O desconto atual precisa continuar válido para o novo produto.
     */
    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O item de compra precisa de um produto.");
        }
        if (desconto > produto.getDescontoMaximo()) {
            throw new IllegalArgumentException("O desconto atual (" + desconto
                    + "%) passa do máximo permitido para " + produto + ".");
        }
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if (desconto < 0 || desconto > produto.getDescontoMaximo()) {
            throw new IllegalArgumentException(String.format(
                    "Desconto inválido para %s: deve ficar entre 0%% e %.0f%%.", produto, produto.getDescontoMaximo()));
        }
        this.desconto = desconto;
    }
}
