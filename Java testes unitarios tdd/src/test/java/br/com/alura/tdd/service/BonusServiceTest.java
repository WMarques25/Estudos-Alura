package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;  
    
public class BonusServiceTest {

    @Test
    public void bonusZeroParaSalarioAlto() {
        var service = new BonusService();
        assertThrows(IllegalArgumentException.class, 
            () -> service.calcularBonus(new Funcionario("Well", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    public void bonusParaSalario2k() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Well", LocalDate.now(), new BigDecimal("2000")));
        assertEquals(new BigDecimal("200.00"), bonus);
    }

    @Test
    public void bonusParaSalario10k() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Well", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
    