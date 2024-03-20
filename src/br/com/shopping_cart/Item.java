package br.com.shopping_cart;

import java.math.BigDecimal;

public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;


    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorTotal() {
        //Multiplicamos o valor de cada item pela quantidade.
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
