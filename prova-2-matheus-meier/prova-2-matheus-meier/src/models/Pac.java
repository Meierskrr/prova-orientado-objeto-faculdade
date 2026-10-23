//Matheus Hermann Starke Meier

package models;

public class Pac implements TipoEntrega{
    
    @Override 
    public double calcularEntrega(double peso) {

        if ((peso <= 0) || (peso > 2)) {
            throw new IllegalArgumentException("Campo peso inválido");
        }

        else if (peso <= 1) {
            return 10;
        }

        else {
            return 15;
        }
     
    }
}
