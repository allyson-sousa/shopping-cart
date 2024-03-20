package br.com.shopping_cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoComprasFactory {

    private Map<String, CarrinhoCompras> carrinhos;

    public CarrinhoComprasFactory() {
        this.carrinhos = new HashMap<>();
    }

    public CarrinhoCompras criar(String identificacaoCliente) {
        //Verifica se já existe um carrinho para o cliente passado como parâmetro.
        if (!carrinhos.containsKey(identificacaoCliente)) {
            //Se não existir, criamos um novo carrinho
            carrinhos.put(identificacaoCliente, new CarrinhoCompras());
        }
        //Retorna o carrinho criado
        return carrinhos.get(identificacaoCliente);
    }

    public BigDecimal getValorTicketMedio() {
        //Iniciamos o valor total do carrinho com 0
        if (carrinhos.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal valorTotal = BigDecimal.ZERO;
        //Percorremos todos os itens do carrinho, somando o valorTotal de cada item a var valorTotal.
        for (CarrinhoCompras carrinho : carrinhos.values()) {
            valorTotal = valorTotal.add(carrinho.getValorTotal());
        }
        //Obtemos a quantidade.
        BigDecimal quantidadeCarrinhos = new BigDecimal(carrinhos.size());
        //Arredondando para duas casas decimais, outra opção seria usar o DecimalFormat.
        BigDecimal ticketMedio = valorTotal.divide(quantidadeCarrinhos, 2, BigDecimal.ROUND_HALF_UP);
        return ticketMedio;
    }

    public boolean invalidar(String identificacaoCliente) {
        //Verificamos se existe um carrinho de compras associado ao cliente
        if (carrinhos.containsKey(identificacaoCliente)) {
            carrinhos.remove(identificacaoCliente);
            return true; // Cliente possuo um carrinho de compras.
        }
        return false; //Cliente não possui um carrinho.
    }
}
