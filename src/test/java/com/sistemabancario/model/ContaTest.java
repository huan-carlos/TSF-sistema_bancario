package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

public class ContaTest {

    private final Conta conta = new Conta();

    @Test
    void setNumeroR01a() {
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero("1234"));
        //verifica se uma excessão foi lançada pelo metodo testado.
        //conta.setPoupanca(true);
    }

    @Test
    void setNumeroR01b() {
        final String invalido = "abcde-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
        final String obtido = conta.getNumero();
        assertNotEquals(invalido, obtido);
    }

    @Test
    void setNumeroR01c() {
        final String invalido = "12345-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
    }

    @Test
    void isPoupancaR02() {
        assertFalse(conta.isPoupanca());
    }

    @Test
    void setLimitiContaComumR3a() {
        final double limite = 1000;
        conta.setEspecial(false);
        assertThrows(IllegalStateException.class, () -> conta.setLimite(limite));
    }

    @Test
    void setLimitiContaEspecialR3b() {
        final double limite = 1000;
        conta.setEspecial(true);
        conta.setLimite(limite);
        assertEquals(limite, conta.getLimite());
    }

    @Test
    void getSaldoTotalR6a() {
        final double limite = 1000, saldo = 200, saldoTotal = 1200;
        conta.setEspecial(true);
        conta.setLimite(limite);
        conta.setSaldo(saldo);
        assertEquals(saldoTotal, conta.getSaldoTotal());
    }

    @Test
    void getSaldoTotalR6b() {
        final double limite = 0.2, saldo = 0.1, saldoTotalEsperado = 0.3;
        conta.setEspecial(true);
        conta.setLimite(limite);
        conta.setSaldo(saldo);
        final double esperado = conta.getSaldoTotal();
        assertEquals(saldoTotalEsperado, esperado, 0.0000001);
    }
}
