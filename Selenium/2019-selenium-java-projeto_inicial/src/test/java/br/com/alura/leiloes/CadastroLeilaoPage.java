package br.com.alura.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroLeilaoPage {

    private ChromeDriver browser;
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    
    
    public CadastroLeilaoPage(ChromeDriver browser) {
        System.setProperty("webdriver.chrome.driver","C:/Users/welli/Desktop/GitHub Repositorys/Estudos-Alura/Selenium/2019-selenium-java-projeto_inicial/src/Drivers/chromedriver.exe");
        this.browser = browser;
        // browser.navigate().to(URL_LEILOES);
    }

    public void fechar() {
        this.browser.quit();
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("não deve estar em branco") &&
                pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }



}
