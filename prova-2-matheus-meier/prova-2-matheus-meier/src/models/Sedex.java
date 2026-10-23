//Matheus Hermann Starke Meier

package models;

public class Sedex implements TipoEntrega {
    

    @Override 
    public double calcularEntrega(double peso) {

        if ((peso <= 0)) {
            throw new IllegalArgumentException("Campo peso inválido");
        }

        else if (peso <= 0.5) {
            return 12.50;
        }

        else {
            return 14.50 + (1.5 * Math.floor((peso - 0.5) * 10));
        }
     
    }
}
