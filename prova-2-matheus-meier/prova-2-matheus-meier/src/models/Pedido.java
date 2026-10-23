//Matheus Hermann Starke Meier

package models;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<Item> itens;
    private TipoEntrega tipoEntrega;

    public Pedido(TipoEntrega tipoEntrega) {
        setTipoEntrega(tipoEntrega);

        criarNovaLista();
    }

    public void criarNovaLista() {
        this.itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public void setItens(ArrayList<Item> itens) {

        if (itens == null) {
            throw new IllegalArgumentException("Campo itens inválido");
        }

        this.itens = itens;
    }

    public void incluirItem(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Campo item inválido");
        }

        this.itens.add(item);
    }

    public void removerItem(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Campo item inválido");
        }

        this.itens.remove(item);
    }

    /**
     * @return calcularPesoPedido é necessário calcular o peso total do pedido.
     *         Deve-se utilizar o cálculo utilizando uma váriavel acumuladora para
     *         somar os pesos de todos os itens.
     *         Esta variavel acumuladora deve ser inicializada com zero e
     *         incrementada com o peso de cada item do pedido através de um for.
     */
    public double calcularPesoPedido() {

        double pesoPedido = 0;

        for (Item item: itens) {
            pesoPedido += item.getPeso();
        }

        return pesoPedido;
    }

    /**
     * @return calcularPrecoEntrega é necessário calcular o preço total da entrega.
     *         Deve-se utilizar o cálculo utilizando uma váriavel acumuladora para
     *         somar os preços de todos os itens.
     *         Esta variavel acumuladora deve ser inicializada com zero e
     *         incrementada com o preço de cada item do pedido através de um for.
     *         Seguindo as regras de custo de envio por peso e tipo de entrega.
     */
    public double calcularPrecoEntrega() {

        double precoEntrega = getTipoEntrega().calcularEntrega(calcularPesoPedido());

        return precoEntrega;
    }

    public double calcularValorPedido() {
        
        double valorTotal = 0;

        for (Item item : itens) {
            valorTotal += item.getValor();
        }

        return valorTotal;
    }

    /**
     * Calcula o valor total do pedido, incluindo o valor dos itens e o custo de
     * entrega.
     * 
     * @return deve somar os valores do total do pedido e total de entrega.
     */
    public double calcularValorTotal() {

        double totalDoPedido = calcularValorPedido() + calcularPrecoEntrega();
        
        return totalDoPedido;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {

        if (tipoEntrega == null) {
            throw new IllegalArgumentException("Campo Tipo entrega inválido");
        }

        this.tipoEntrega = tipoEntrega;
    }

}
