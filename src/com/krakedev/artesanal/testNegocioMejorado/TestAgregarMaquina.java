package com.krakedev.artesanal.testNegocioMejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

	@Test
	public void testAgregarMaquinaAgregaALista() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		boolean agregado = negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);

		assertTrue(agregado);
		assertEquals(1, negocio.getMaquinas().size());

		String codigo = negocio.getMaquinas().get(0).getCodigo();
		assertTrue(codigo.startsWith("M-"));
		assertEquals("Pilsener", negocio.getMaquinas().get(0).getNombreCerveza());
		assertEquals("Cerveza rubia", negocio.getMaquinas().get(0).getDescripcion());
		assertEquals(0.02, negocio.getMaquinas().get(0).getPrecioPorMl(), 0.0001);
		assertEquals(0, negocio.getMaquinas().get(0).getCantidadActual(), 0.0001);

	}

	@Test
	public void testAgregarVariasMaquinas() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);
		SoportePruebas.agregarMaquina(negocio, "Stout", "Cerveza negra", 0.05);
		SoportePruebas.agregarMaquina(negocio, "IPA", "Cerveza lupulada", 0.04);

		assertEquals(3, negocio.getMaquinas().size());
		assertNotNull(negocio.recuperarMaquina(negocio.getMaquinas().get(1).getCodigo()));

	}

	@Test
	public void testAgregarMaquinaNoRepiteCodigos() {

		NegocioMejorado negocio = new NegocioMejorado("Cervezas Artesanales");

		boolean rejected = false;
		int agregadas = 0;

		// solo existen 100 codigos posibles (M-1 ... M-100)
		for (int i = 0; i < 101; i++) {
			if (negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02)) {
				agregadas++;
			} else {
				rejected = true;
			}
		}

		assertTrue(rejected, "Debe rechazar un codigo duplicado");
		assertEquals(agregadas, negocio.getMaquinas().size());
		assertTrue(negocio.getMaquinas().size() <= 100, "Solo existen 100 codigos posibles");

		// ningun codigo queda repetido dentro de la lista
		ArrayList<String> codigos = new ArrayList<>();
		for (int i = 0; i < negocio.getMaquinas().size(); i++) {
			codigos.add(negocio.getMaquinas().get(i).getCodigo());
		}
		assertEquals(codigos.size(), new HashSet<>(codigos).size());

	}

}
