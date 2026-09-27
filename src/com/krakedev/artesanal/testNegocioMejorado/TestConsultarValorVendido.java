package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestConsultarValorVendido {

	@Test
	public void testConsultarValorVendidoSinClientes() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		assertEquals(0, negocio.consultarValorVendido(), 0.0001);

	}

	@Test
	public void testConsultarValorVendidoUnCliente() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);
		negocio.cargarMaquinas();
		negocio.registrarCliente("Ana Torres", "0102030405");

		String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();
		negocio.consumirCerveza("100", codigoMaquina, 500);
		negocio.consumirCerveza("100", codigoMaquina, 1000);

		assertEquals(30, negocio.consultarValorVendido(), 0.0001);

	}

	@Test
	public void testConsultarValorVendidoVariosClientes() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		SoportePruebas.agregarMaquina(negocio, "Pilsener", "Cerveza rubia", 0.02);
		SoportePruebas.agregarMaquina(negocio, "Stout", "Cerveza negra", 0.05);
		negocio.cargarMaquinas();

		String pilsener = negocio.getMaquinas().get(0).getCodigo();
		String stout = negocio.getMaquinas().get(1).getCodigo();

		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");

		negocio.consumirCerveza("100", pilsener, 500);
		negocio.consumirCerveza("101", stout, 200);

		assertEquals(20, negocio.consultarValorVendido(), 0.0001);

	}

}
