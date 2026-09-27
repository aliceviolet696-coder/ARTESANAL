package com.krakedev.artesanal.testNegocioMejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class SoportePruebas {

	// agregarMaquina genera un codigo aleatorio, por lo que puede ser rechazado
	// si ya existe: se reintenta hasta que la maquina sea agregada.
	public static Maquina agregarMaquina(NegocioMejorado negocio, String nombreCerveza, String descripcion,
			double precioPorMl) {
		while (!negocio.agregarMaquina(nombreCerveza, descripcion, precioPorMl)) {
		}
		return negocio.getMaquinas().get(negocio.getMaquinas().size() - 1);
	}

}
