package br.com.shopping_cart;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CarrinhoCompras {

    private List<Item> itens;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        //Validando o produto no carrinho de compras
        if (produto == null || valorUnitario == null || quantidade < 0) {
            throw new IllegalArgumentException("Produto, valor unitário ou quantidade inválidos.");
        }
        for (Item item : itens) {
            //Caso o item já exista no carrinho para o mesmo produto
            if (item.getProduto().equals(produto)) {
                //A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro
                item.setQuantidade(item.getQuantidade() + quantidade);
                //Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
                // passado como parâmetro.
                if (!item.getValorUnitario().equals(valorUnitario)) {
                    item.setValorUnitario(valorUnitario);
                }
                return;
            }
        }
        //Permite a adição de um novo item no carrinho de compras
        itens.add(new Item(produto, valorUnitario, quantidade));
    }

    public boolean removerItem(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido."); // or throw new IllegalArgumentException("Selecione um produto.");
        }
        for (Item item : itens) {
            if (item.getProduto().equals(produto)) {
                itens.remove(item);
                return true; //Item removido do carrinho
            }
        }
        return false; // Nenhum item encontrado no carrinho
    }

    public boolean removerItem(int posicaoItem) {
        if (posicaoItem < 0 || posicaoItem >= itens.size()) {
            throw new IllegalArgumentException("Posição inválida");
        }
        itens.remove(posicaoItem);
        return true; //Item removido.
    }

    public BigDecimal getValorTotal() {
        //Iniciamos o valor total do carrinho com 0
        BigDecimal valorTotal = BigDecimal.ZERO;
        //Percorremos todos os itens do carrinho, somando o valorTotal de cada item a var valorTotal.
        for (Item item : itens) {
            valorTotal = valorTotal.add(item.getValorTotal());
        }
        //Retorna o valorTotal do carrinho.
        return valorTotal;
    }

    public Collection<Item> getItens() {
        return new ArrayList<>(itens);
    }
}