package edu.fatec.lp2.exercicio2.compra;

import java.util.Arrays;

/**
 * Lista de compras com uma quantidade máxima de itens.
 */
public class ListaCompra implements Calculavel {

    private ItemCompra[] itensCompra;
    private int qtdeMax;
    private int qtdeItens; // acréscimo ao diagrama: quantas posições do array estão ocupadas

    public ListaCompra(int qtdeMax) {
        if (qtdeMax <= 0) {
            throw new IllegalArgumentException("A lista precisa comportar pelo menos 1 item.");
        }
        this.qtdeMax = qtdeMax;
        this.itensCompra = new ItemCompra[qtdeMax];
        this.qtdeItens = 0;
    }

    /** Adiciona itens até o limite; depois disso, recusa. */
    public void incluir(ItemCompra item) {
        if (item == null) {
            throw new IllegalArgumentException("Não é possível incluir um item vazio.");
        }
        if (qtdeItens >= qtdeMax) {
            System.out.println("Lista cheia (máx. " + qtdeMax + " itens): "
                    + item.getProduto() + " não foi incluído.");
            return;
        }
        itensCompra[qtdeItens++] = item;
    }

    /** Preço total: soma do calcularPreco() de cada item. */
    @Override
    public double calcularPreco() {
        double total = 0;
        for (int i = 0; i < qtdeItens; i++) {
            total += itensCompra[i].calcularPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de compras (" + qtdeItens + "/" + qtdeMax + " itens)\n");
        for (int i = 0; i < qtdeItens; i++) {
            sb.append("  ").append(i + 1).append(". ").append(itensCompra[i]).append('\n');
        }
        sb.append(String.format("  TOTAL: R$ %.2f", calcularPreco()));
        return sb.toString();
    }

    // ===== Getters =====
    // Correção de design: sem setItensCompra e setQtdeMax. Trocar o array ou o limite
    // por fora quebraria a regra da quantidade máxima. Itens entram só por incluir().

    /** Retorna uma cópia só com os itens preenchidos, para ninguém mexer no array interno. */
    public ItemCompra[] getItensCompra() {
        return Arrays.copyOf(itensCompra, qtdeItens);
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public int getQtdeItens() {
        return qtdeItens;
    }
}
