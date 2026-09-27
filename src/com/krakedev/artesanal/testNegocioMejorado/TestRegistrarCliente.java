package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestRegistrarCliente {

	@Test
	public void testRegistrarCliente() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.registrarCliente("Ana Torres", "0102030405");

		assertEquals(1, negocio.getClientes().size());
		assertEquals("Ana Torres", negocio.getClientes().get(0).getNombre());
		assertEquals("0102030405", negocio.getClientes().get(0).getCedula());
		assertEquals("100", negocio.getClientes().get(0).getCodigo());
		assertEquals(0, negocio.getClientes().get(0).getTotalConsumido(), 0.0001);

	}

	@Test
	public void testRegistrarVariosClientesCodigosConsecutivos() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");
		negocio.registrarCliente("Maria Lopez", "2102030405");

		assertEquals(3, negocio.getClientes().size());
		assertEquals("100", negocio.getClientes().get(0).getCodigo());
		assertEquals("101", negocio.getClientes().get(1).getCodigo());
		assertEquals("102", negocio.getClientes().get(2).getCodigo());

	}

	@Test
	public void testBuscarClientePorCedula() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");

		assertNotNull(negocio.buscarClientePorCedula("1102030405"));
		assertEquals("Luis Ramirez", negocio.buscarClientePorCedula("1102030405").getNombre());
		assertNull(negocio.buscarClientePorCedula("9999999999"));

	}

	@Test
	public void testBuscarClientePorCodigo() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");
		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");

		assertNotNull(negocio.buscarClientePorCodigo("101"));
		assertEquals("1102030405", negocio.buscarClientePorCodigo("101").getCedula());
		assertNull(negocio.buscarClientePorCodigo("999"));

	}

}
