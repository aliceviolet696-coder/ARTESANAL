package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestCervezaAI {

    @Test
    public void testServirCervezaConConstructorCompleto() {

        // Se crea una maquina utilizando el constructor de cinco parametros.
        Maquina rubia = new Maquina(
                "M001",
                "Pilsener",
                "Cerveza rubia",
                0.02,
                8000
        );

        // La maquina se llena hasta su capacidad maxima menos 200 ml.
        // 8000 - 200 = 7800 ml.
        rubia.llenarMaquina();

        // Se sirven 100 ml.
        // El valor a pagar es 100 * 0.02 = 2.00.
        double valor = rubia.servirCerveza(100);

        assertEquals(2.00, valor, 0.0001);

        // Quedan 7800 - 100 = 7700 ml.
        assertEquals(7700, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testServirCervezaConConstructorDeCuatroParametros() {

        // Se utiliza el constructor que establece una capacidad maxima de 10000 ml.
        Maquina rubia = new Maquina(
                "M002",
                "Pilsener",
                "Cerveza rubia",
                0.02
        );

        // La maquina se llena hasta 10000 - 200 = 9800 ml.
        rubia.llenarMaquina();

        // Se sirven 200 ml.
        // El valor a pagar es 200 * 0.02 = 4.00.
        double valor = rubia.servirCerveza(200);

        assertEquals(4.00, valor, 0.0001);

        // Quedan 9800 - 200 = 9600 ml.
        assertEquals(9600, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testServirCervezaSinSuficienteCantidad() {

        // Se crea una maquina con capacidad maxima de 8000 ml.
        Maquina rubia = new Maquina(
                "M003",
                "Pilsener",
                "Cerveza rubia",
                0.02,
                8000
        );

        // La maquina queda con 7800 ml disponibles.
        rubia.llenarMaquina();

        // Se solicitan 8000 ml, pero solamente hay 7800 ml.
        // Por lo tanto, no debe servir cerveza.
        double valor = rubia.servirCerveza(8000);

        // Si no puede servir, debe retornar cero.
        assertEquals(0, valor, 0.0001);

        // La cantidad actual no debe modificarse.
        assertEquals(7800, rubia.getCantidadActual(), 0.0001);

    }

    @Test
    public void testServirTodaLaCantidadDisponible() {

        // Se crea una maquina con capacidad maxima de 8000 ml.
        Maquina rubia = new Maquina(
                "M004",
                "Pilsener",
                "Cerveza rubia",
                0.02,
                8000
        );

        // La maquina queda con 7800 ml.
        rubia.llenarMaquina();

        // Se solicita exactamente toda la cerveza disponible.
        // 7800 * 0.02 = 156.00.
        double valor = rubia.servirCerveza(7800);

        assertEquals(156.00, valor, 0.0001);

        // Después de servir toda la cerveza, quedan 0 ml.
        assertEquals(0, rubia.getCantidadActual(), 0.0001);

    }

}