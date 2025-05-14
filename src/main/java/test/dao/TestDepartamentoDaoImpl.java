package test.dao;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entities.Departamento;

public class TestDepartamentoDaoImpl {

	private static DepartamentoDao dDao;

	static {
		dDao = new DepartamentoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		insertar();
		uno();
		actualizar();
		borrar();
		todos();
	}

	private static void uno() {
		System.out.println("\nBusco uno");
		System.out.println(" - Busco uno por el id 9: " + dDao.findById(9));
		System.out.println(" - Busco uno que no existe debe dar null: " + dDao.findById(9999999));
	}

	private static void insertar() {
		System.out.println("\nInserto uno");

		Departamento d = new Departamento(9, "Del pez", "Tiburon");
		Departamento d2 = new Departamento(9, "Del pez", "morsa");

		System.out.println(" - Inserto uno debe dar 1: " + dDao.insert(d));
		System.out.println(" - Inserto uno con l mismo id debe dar 0: " + dDao.insert(d2));
	}

	private static void actualizar() {
		System.out.println("\nActualizo uno");

		Departamento d = dDao.findById(9);
		d.setNombre("Trucha");

		System.out.println(" - Actualizo uno debe dar 1: " + dDao.update(d));
		System.out.println(" - Le puse como nombre Trucha : " + dDao.findById(9));
	}

	private static void borrar() {
		System.out.println("\nBorro uno");

		System.out.println(" - Borro el ultimo que meti debe dar 1: " + dDao.deleteById(9));
		System.out.println(" - Borro el mismo otra vez debe dar 0: " + dDao.deleteById(9));
	}

	private static void todos() {
		System.out.println("\nTodos");

		dDao.findAll().forEach(ele -> System.out.println(ele));
	}

}
