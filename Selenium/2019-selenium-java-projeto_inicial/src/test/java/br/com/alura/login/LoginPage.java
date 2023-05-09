package br.com.alura.login;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private ChromeDriver browser;
    
    
    
    public LoginPage() {
        System.setProperty("webdriver.chrome.driver","C:/Users/welli/Desktop/GitHub Repositorys/Estudos-Alura/Selenium/2019-selenium-java-projeto_inicial/src/Drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void preencheFormularioDeLogin(String user, String pass) {
        browser.findElement(By.id("username")).sendKeys(user);
        browser.findElement(By.id("password")).sendKeys(pass);
    }

    public void efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isPaginaDeLoginError() {
        return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (Exception e) {
            return null;
        }
        
    }

    public void navegaParaPaginaDeLances() {
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String string) {
        return browser.getPageSource().contains(string);
    }


}
