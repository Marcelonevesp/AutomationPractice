package br.com.page;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class WomenPage extends BasePage {

	public void adicionarItemUmCarrinho() {
		moverMouse(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div"), "//a[contains(@title, 'Add to cart')]");
	}

	public void adicionarItemDoisCarrinho() {
		moverMouse(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div"), ".//a[contains(@title, 'Add to cart') and (@data-id-product='2')]");
	}
	
	public void clicarContinuarCompra() {
		clicarBotao(By.xpath(".//span[contains(@title,'Continue shopping')]"));
	}
	
	public void clicarFinalizarCompra() {
		clicarBotao(By.xpath(".//a[contains(@title,'Proceed to checkout')]"));	
	}
	
	public int obterQuantidadeRegistros() {
		return obterQuantidadeLinhas(By.xpath("//*[@id='cart_summary']/tbody/tr"));
	}
	
	public int obterQuantidadeItemCarrinho() {
		String qtde = obterTexto(By.xpath("//div[@class='shopping_cart']//span"));
		return Integer.parseInt(qtde);
	}
}
