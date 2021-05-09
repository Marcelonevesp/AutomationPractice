package br.com.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.page.MenuPage;
import br.com.page.WomenPage;

public class WomenTest extends BaseTest {
	
	static MenuPage menu = new MenuPage();
	static WomenPage women = new WomenPage();

	@Test
	public static void adicionarDoisItensNoCarrinho() {
		menu.acessarPaginaWomen();
		
		women.adicionarItemUmCarrinho();
		women.clicarContinuarCompra();
		
		Assert.assertEquals(1, women.obterQuantidadeItemCarrinho());
		
		women.adicionarItemDoisCarrinho();
		women.clicarFinalizarCompra();
		
		Assert.assertEquals(2, women.obterQuantidadeItemCarrinho());
		Assert.assertEquals(2, women.obterQuantidadeRegistros());
	}
}
