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
		Assert.assertEquals("$33.02", cart.obterValorTotalItem()); //verifica se foi adicionado o item
		
		cart.prosseguirCompra(); //prossegue para a aba "Address"
		
		cart.prosseguirCompra(); //prossegue para a aba "Shipping"
		
		cart.aceitarTermo(); //Aceita termo e condições
		Assert.assertTrue(cart.verificarCheckMarcado()); //Verificar se está marcado
		cart.prosseguirComCompra(); //Prossegue para a tela de pagamento
		
		cart.pagarPorBankWire();
	}
}
