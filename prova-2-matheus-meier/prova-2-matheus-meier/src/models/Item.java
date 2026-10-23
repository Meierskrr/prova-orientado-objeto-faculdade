//Matheus Hermann Starke Meier

package models;

public class Item {
    
    private double valor;
    private double peso;

    public Item(double valor, double peso) {
        setValor(valor);
        setPeso(peso);
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Campo valor inválido");
        }

        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Campo peso inválido");
        }

        this.peso = peso;
    }

}
