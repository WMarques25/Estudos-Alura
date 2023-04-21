package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
    
    private ReajusteService service;
    private Funcionario funcionario;
    private static int contador = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Inicio dos testes.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Fim dos testes.");
    }

    @AfterEach
    public void afterEach() {
        contador++;
        System.out.println("Fim do teste " + contador + ".");
    }

    @BeforeEach
    public void inicializar() {
        service = new ReajusteService();
        funcionario = new Funcionario("Well", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteBOM() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteOTIMO() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteEXCELENTE() {
        service.concederReajuste(funcionario, Desempenho.EXCELENTE);
        assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
    }

}
