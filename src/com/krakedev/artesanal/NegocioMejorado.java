package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private String nombre;
	private int ultimoCodigo = 100;
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();

	public NegocioMejorado() {
		this.maquinas = new ArrayList<>();
	}

	public NegocioMejorado(String nombre) {
		this.nombre = nombre;
		this.maquinas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina existe = recuperarMaquina(codigo);

		if (existe != null) {
			return false;
		}

		Maquina maquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
		maquinas.add(maquina);
		return true;
	}

	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			maquina.llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			if (maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}

	public void asignarCodigoCliente(Cliente cliente) {
		String codigo = String.valueOf(ultimoCodigo);
		cliente.setCodigo(codigo);
		ultimoCodigo++;
	}

	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		asignarCodigoCliente(cliente);
		clientes.add(cliente);
	}

	public Cliente buscarClientePorCedula(String cedula) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}

	public Cliente buscarClientePorCodigo(String codigo) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getCodigo().equals(codigo)) {
				return cliente;
			}
		}
		return null;
	}

}
