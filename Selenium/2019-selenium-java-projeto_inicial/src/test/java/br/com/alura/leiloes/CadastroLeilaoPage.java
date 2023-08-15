package br.com.alura.leiloes;

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



}
