package br.com.page;

import static br.com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.core.BasePage;

public class CartPage extends BasePage {
	
	private static WebDriverWait wait = new WebDriverWait(getDriver(),30);

	public void aumentarUmItemCarrinho(String colunaBusca, String colunaQuantidade) {
		WebElement celula = obterCelula("cart_summary", colunaBusca, "Faded Short Sleeve T-shirts", colunaQuantidade);
		WebElement botaoAumentar = celula.findElement(By.xpath("//a[@title='Add']"));
		botaoAumentar.click();
	}
	
	public String obterValorTotalItem() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='cart_summary']/tbody//td[6]"), "$33.02"));
		return obterCelula("cart_summary", "Description", "Faded Short Sleeve T-shirts", "Total").getText();
	}
	
	public void prosseguirCompra() {
		clicarBotao(By.xpath("//span[text()='Proceed to checkout']"));
	}
	
	public void prosseguirComCompra() {
		clicarBotao(By.xpath("//*[@id='form']//button"));
	}
	
	public void aceitarTermo() {
		clicarCheck("cgv");
	}
	
	public boolean verificarCheckMarcado() {
		return verificarRadioMarcado("cgv");
	}

	public void selecionarPagamentoPorBankWire() {
		clicarBotao(By.xpath("//a[@title='Pay by bank wire']"));
	}

	public String confirmaTipoPagamento() {
		return obterTexto(By.xpath("//*[@id='center_column']//h3"));
	}
	
	public void confirmarPedido() {
		clicarBotao(By.xpath("//span[contains(text(), 'I confirm my order')]"));
	}

	public String confirmaPedidoFinalizado() {
		return obterTexto(By.xpath("//*[@class='dark' and text()='Your order on My Store is complete.']"));
	}
}
