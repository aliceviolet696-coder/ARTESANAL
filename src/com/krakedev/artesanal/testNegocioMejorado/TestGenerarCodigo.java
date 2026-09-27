package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigo {

	@Test
	public void testGenerarCodigoFormato() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		for (int i = 0; i < 200; i++) {
			String codigo = negocio.generarCodigo();
			assertNotNull(codigo);
			assertTrue(codigo.startsWith("M-"), "El codigo debe iniciar con M-: " + codigo);
		}

	}

	@Test
	public void testGenerarCodigoRango() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		for (int i = 0; i < 500; i++) {
			String codigo = negocio.generarCodigo();
			int numero = Integer.parseInt(codigo.substring(2));
			assertTrue(numero >= 1 && numero <= 100, "Numero fuera de rango: " + numero);
		}

	}

}
