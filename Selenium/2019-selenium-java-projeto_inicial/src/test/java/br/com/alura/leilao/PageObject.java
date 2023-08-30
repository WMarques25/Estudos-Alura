package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
    
    protected ChromeDriver browser;

    public PageObject(ChromeDriver browser) {
        System.setProperty("webdriver.chrome.driver","C:/Users/welli/Desktop/GitHub Repositorys/Estudos-Alura/Selenium/2019-selenium-java-projeto_inicial/src/Drivers/chromedriver.exe");
        if(browser == null) {
            this.browser = new ChromeDriver();
        }else {
            this.browser = browser;
        }

        this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    public void fechar() {
        this.browser.quit();
    }

}
