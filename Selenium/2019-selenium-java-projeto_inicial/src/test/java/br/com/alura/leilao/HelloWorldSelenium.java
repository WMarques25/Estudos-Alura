package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver","C:/Users/welli/Desktop/GitHub Repositorys/Estudos-Alura/Selenium/2019-selenium-java-projeto_inicial/src/Drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }
    
}
