package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.agregarMaquina("Pilsener", "Cerveza rubia de la casa", 0.02);
		negocio.agregarMaquina("Stout", "Cerveza negra de avena", 0.05);
		negocio.cargarMaquinas();

		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");

		String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();
		String codigoCliente = negocio.buscarClientePorCedula("0102030405").getCodigo();

		negocio.consumirCerveza(codigoCliente, codigoMaquina, 500);

		System.out.println("Codigo cliente:" + codigoCliente);
		System.out.println("Codigo maquina:" + codigoMaquina);
		System.out.println("Total consumido cliente:"
				+ negocio.buscarClientePorCodigo(codigoCliente).getTotalConsumido());
		System.out.println("Valor vendido:" + negocio.consultarValorVendido());

	}

}
