package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCargarMaquinas {

	@Test
	public void testCargarMaquinas() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		SoportePruebas.agregarMaquina(negocio, "Pilsener", "Cerveza rubia", 0.02);
		SoportePruebas.agregarMaquina(negocio, "Stout", "Cerveza negra", 0.05);

		negocio.cargarMaquinas();

		assertEquals(9800, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);
		assertEquals(9800, negocio.getMaquinas().get(1).getCantidadActual(), 0.0001);

	}

	@Test
	public void testCargarMaquinasSinMaquinas() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.cargarMaquinas();

		assertEquals(0, negocio.getMaquinas().size());

	}

}
