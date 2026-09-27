package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.registrarCliente("Ana Torres", "0102030405");
		negocio.registrarCliente("Luis Ramirez", "1102030405");

		System.out.println("Clientes registrados:" + negocio.getClientes().size());

		for (int i = 0; i < negocio.getClientes().size(); i++) {
			Cliente cliente = negocio.getClientes().get(i);
			System.out.println("Codigo:" + cliente.getCodigo()
					+ ", Nombre:" + cliente.getNombre()
					+ ", Cedula:" + cliente.getCedula());
		}

	}

}
