package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

	@Test
	public void testRecuperarMaquinaExistente() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		SoportePruebas.agregarMaquina(negocio, "Pilsener", "Cerveza rubia", 0.02);
		SoportePruebas.agregarMaquina(negocio, "Stout", "Cerveza negra", 0.05);

		Maquina agregada = negocio.getMaquinas().get(1);
		Maquina recuperada = negocio.recuperarMaquina(agregada.getCodigo());

		assertNotNull(recuperada);
		assertSame(agregada, recuperada);
		assertEquals("Stout", recuperada.getNombreCerveza());

	}

	@Test
	public void testRecuperarMaquinaInexistente() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);

		assertNull(negocio.recuperarMaquina("M-999"));

	}

	@Test
	public void testRecuperarMaquinaListaVacia() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		assertNull(negocio.recuperarMaquina("M-1"));

	}

}
