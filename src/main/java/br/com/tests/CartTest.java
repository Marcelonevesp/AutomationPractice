package br.com.tests;

import static br.com.tests.WomenTest.adicionarDoisItensNoCarrinho;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.page.CartPage;


public class CartTest extends BaseTest {
	
	CartPage cart = new CartPage();

	@Test
	public void finalizarItensCompra() {
		
		adicionarDoisItensNoCarrinho(); //Adiciona dois itens no carrinho
		cart.aumentarUmItemCarrinho("Description", "Qty"); //Adiciona mais um item do produto
		String valorTotal = cart.obterValorCompraTotal();
		Assert.assertEquals("$33.02", cart.obterValorTotalItem()); //verifica se foi adicionado o item
		Assert.assertEquals("$62.02", valorTotal); //verifica valor total
		
		cart.prosseguirCompra(); //prossegue para a aba "Address"
		cart.prosseguirCompra(); //prossegue para a aba "Shipping"	
		cart.aceitarTermo(); //Aceita termo e condições
		Assert.assertTrue(cart.verificarCheckMarcado()); //Verificar se está marcado
		
		cart.prosseguirComCompra(); //Prossegue para a tela de pagamento
		cart.selecionarPagamentoPorBankWire(); //Seleciona tipo de pagamento por Bank Wire
		Assert.assertEquals("BANK-WIRE PAYMENT.", cart.confirmaTipoPagamento()); //Confirma tipo de pagamento selecionado
		
		cart.confirmarPedido(); //Confirma o pagamento
		Assert.assertEquals("Your order on My Store is complete.", cart.confirmaPedidoFinalizado());
		Assert.assertEquals(valorTotal, cart.confirmaValorPago());
	}
}
