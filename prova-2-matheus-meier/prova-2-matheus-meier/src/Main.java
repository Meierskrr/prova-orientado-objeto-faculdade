//Matheus Hermann Starke Meier

import java.util.Scanner;
import java.util.ArrayList;

import models.*;

public class Main {

    /**
     * LEIA - ME.
     * O desenvolvedor começou a implementar a lógica, porem ele ainda não aprendeu
     * a herança, polimorfismo e outros conceitos avançados de orientação a objetos.
     * Por isso você deverá finalizar o que já foi começado.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pedido pedido;

        String tipoEntrega = "";

        while (true) {
            System.out.print("Digite o tipo de entrega (Pac, Sedex, Retirada): ");
            tipoEntrega = scanner.nextLine().toUpperCase().replace(" ", "");

            if (tipoEntrega.equals("PAC")) {
                pedido = new Pedido(new Pac());
                break;
            }

            else if (tipoEntrega.equals("SEDEX")) {
                pedido = new Pedido(new Sedex());
                break;
            }

            else if (tipoEntrega.equals("RETIRADA")) {
                pedido = new Pedido(new Retirada());
                break;
            }

            System.out.println("Por favor, informe um tipo de entrega válido\n");
        }

        String resposta = "";

        while (!resposta.equals("N")) {
            double valor = 0;
            double peso = 0;

            System.out.print("Digite o valor do item: ");
            valor = scanner.nextDouble();

            System.out.print("Digite o peso do item: ");
            peso = scanner.nextDouble();
            
            scanner.nextLine(); // Limpa o buffer

            Item item = new Item(valor, peso);
            pedido.incluirItem(item);

            System.out.print("Quer adicionar mais itens [S/N]: ");
            resposta = scanner.nextLine().toUpperCase().replace(" ", "");
        }

        System.out.println("------------------------");
        System.out.printf("Peso pedido: %.2fKg%n", pedido.calcularPesoPedido());
        System.out.printf("Preço entrega: R$%.2f (%s)%n", pedido.calcularPrecoEntrega(), tipoEntrega);
        System.out.printf("Preço pedido: R$%.2f%n", pedido.calcularValorPedido());
        System.out.printf("Valor total: R$%.2f", pedido.calcularValorTotal());
    }
}

/*
 * Pedido pedido = new Pedido();
 * boolean adicionarMaisItens = true;
 * 
 * 
 * do {
 * System.out.println("Digite o valor do item, exemplo: 5.99 ou 5,99");
 * double valor = utils.Utils.lerValorDouble();
 * System.out.println("Digite o peso do item, exemplo: 0.5 ou 0,5");
 * double peso = utils.Utils.lerValorDouble();
 * Item item = new Item(valor, peso);
 * // o incluirItem, parece que o método tem um erro, como se não tivesse feito
 * o new em alguma coisa, algo em relação ao itens.
 * // creio que tem haver com o .add do array ou lista de itens dentro do
 * pedido.
 * pedido.incluirItem(item);
 * } while (adicionarMaisItens);
 * 
 * System.out.println("Valor do pedido: " + pedido.calcularValorPedido());
 * 
 * // Agora é necessário calcular o frete com base no tipo de entrega.
 * System.out.println("Digite o tipo de entrega (PAC, SEDEX, Retida)");
 */
