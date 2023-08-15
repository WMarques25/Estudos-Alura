package br.com.alura.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroLeilaoPage {

    private ChromeDriver browser;
    
    
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



}
