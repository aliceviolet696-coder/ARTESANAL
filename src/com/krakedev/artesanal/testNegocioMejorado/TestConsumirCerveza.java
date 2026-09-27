package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumirCerveza {

	private NegocioMejorado negocio;
	private String codigoMaquina;

	@BeforeEach
	public void setUp() {

		negocio = new NegocioMejorado("Cervezas Artesanales");
		negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);
		negocio.cargarMaquinas();
		codigoMaquina = negocio.getMaquinas().get(0).getCodigo();
		negocio.registrarCliente("Ana Torres", "0102030405");

	}

	@Test
	public void testConsumirCervezaActualizaCliente() {

		negocio.consumirCerveza("100", codigoMaquina, 500);

		assertEquals(10, negocio.buscarClientePorCodigo("100").getTotalConsumido(), 0.0001);

	}

	@Test
	public void testConsumirCervezaAfectaMaquina() {

		negocio.consumirCerveza("100", codigoMaquina, 500);

		assertEquals(9300, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

	@Test
	public void testConsumirCervezaAcumula() {

		negocio.consumirCerveza("100", codigoMaquina, 500);
		negocio.consumirCerveza("100", codigoMaquina, 500);
		negocio.consumirCerveza("100", codigoMaquina, 1000);

		assertEquals(40, negocio.buscarClientePorCodigo("100").getTotalConsumido(), 0.0001);
		assertEquals(7800, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

	@Test
	public void testConsumirCervezaSinCantidadSuficiente() {

		negocio.consumirCerveza("100", codigoMaquina, 20000);

		assertEquals(0, negocio.buscarClientePorCodigo("100").getTotalConsumido(), 0.0001);
		assertEquals(9800, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

	@Test
	public void testConsumirCervezaClienteInexistente() {

		negocio.consumirCerveza("999", codigoMaquina, 500);

		assertEquals(0, negocio.consultarValorVendido(), 0.0001);
		assertEquals(9800, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

	@Test
	public void testConsumirCervezaMaquinaInexistente() {

		negocio.consumirCerveza("100", "M-999", 500);

		assertEquals(0, negocio.consultarValorVendido(), 0.0001);
		assertEquals(9800, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

}
