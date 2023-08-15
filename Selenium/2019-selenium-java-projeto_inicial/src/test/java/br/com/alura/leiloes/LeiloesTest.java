package br.com.alura.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.login.LoginPage;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }
    
    @Test
    public void deveCadastrarLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        paginaDeLeiloes.carregarFormulario();
    }
}
