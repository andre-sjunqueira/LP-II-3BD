package edu.fatec.lp2.exercicio2.app;

import edu.fatec.lp2.exercicio2.compra.Calculavel;
import edu.fatec.lp2.exercicio2.compra.ItemCompra;
import edu.fatec.lp2.exercicio2.compra.ListaCompra;
import edu.fatec.lp2.exercicio2.modelo.Produto;
import edu.fatec.lp2.exercicio2.modelo.Supermercado;

public class Main {

    public static void main(String[] args) {
        Supermercado mercado = new Supermercado("Supermercados Astolfo");

        // Usando o construtor do diagrama + setters
        Produto arroz = new Produto(mercado);
        arroz.setNome("Arroz");
        arroz.setUnidade("pacote 5 kg");
        arroz.setDescricao("Arroz branco tipo 1");
        arroz.setPreco(27.90);
        arroz.setDescontoMaximo(10);

        // Usando o construtor completo
        Produto feijao = new Produto(mercado, "Feijão", "pacote 1 kg", "Feijão carioca", 8.50, 5);
        Produto leite = new Produto(mercado, "Leite", "caixa 1 L", "Leite integral", 4.99, 15);
        Produto cafe = new Produto(mercado, "Café", "pacote 500 g", "Café torrado e moído", 18.90, 0);

        System.out.println("Produto (toString): " + arroz + " - vendido por " + arroz.getSupermercado().getNome());
        System.out.println();

        ListaCompra lista = new ListaCompra(3);
        lista.incluir(new ItemCompra(arroz, 2, 10));  // 2 x 27,90 com 10%
        lista.incluir(new ItemCompra(feijao, 3, 0));  // 3 x 8,50 sem desconto
        lista.incluir(new ItemCompra(leite, 15));     // construtor do diagrama: quantidade 1
        lista.incluir(new ItemCompra(cafe, 0));       // passa do limite: deve ser recusado

        // Desconto acima do máximo permitido para o produto
        try {
            new ItemCompra(cafe, 1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println();
        System.out.println(lista);

        // A interface comum permite tratar item e lista do mesmo jeito (polimorfismo)
        System.out.println();
        Calculavel[] calculaveis = { lista.getItensCompra()[0], lista };
        for (Calculavel c : calculaveis) {
            System.out.printf("%s -> R$ %.2f%n", c.getClass().getSimpleName(), c.calcularPreco());
        }
    }
}
