package br.com.alura.leiloes;

import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private ChromeDriver browser;
    
    
    public LeiloesPage(ChromeDriver browser) {
        System.setProperty("webdriver.chrome.driver","C:/Users/welli/Desktop/GitHub Repositorys/Estudos-Alura/Selenium/2019-selenium-java-projeto_inicial/src/Drivers/chromedriver.exe");
        this.browser = browser;
        // browser.navigate().to(URL_LEILOES);
    }

    public void fechar() {
        this.browser.quit();
    }

    public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
    }


}
