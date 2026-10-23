//Matheus Hermann Starke Meier

import java.util.Scanner;
import java.util.ArrayList;

import models.*;

public class Main {


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

