package utils;

import java.util.Scanner;

public class Utils {

    private static final Scanner scanner = new Scanner(System.in);
    
    public static double lerValorDouble() {
        String valor = scanner.next();
        if (valor.matches(".*[^0-9,\\.].*")) {
            throw new IllegalArgumentException("Valor inválido: " + valor);
        }
        valor = valor.replace(",", ".");
        return Double.parseDouble(valor);
    }

}
