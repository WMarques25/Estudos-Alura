package br.com.alura.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.login.LoginPage;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }
    
    @Test
    public void deveCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";

        
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
        Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroLeilao() {
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
        Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());
    }
}
