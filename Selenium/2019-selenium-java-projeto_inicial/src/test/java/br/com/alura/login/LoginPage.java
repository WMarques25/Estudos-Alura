package br.com.alura.login;

import org.openqa.selenium.By;

import br.com.alura.leilao.PageObject;
import br.com.alura.leiloes.LeiloesPage;

public class LoginPage extends PageObject{

    private static final String URL_LOGIN = "http://localhost:8080/login";
    
    public LoginPage() {
        super(null);
        browser.navigate().to(URL_LOGIN);
    }

    public void preencheFormularioDeLogin(String user, String pass) {
        browser.findElement(By.id("username")).sendKeys(user);
        browser.findElement(By.id("password")).sendKeys(pass);
    }

    public LeiloesPage efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
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
