package test.dao;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entities.Perfil;

public class TestPerfilDaoImpl {

	private static PerfilDao pDao;
	
	static {
		pDao = new PerfilDaoImplMy8Jpa(); 
	}
	
	public static void main(String[] args) {
		
		buscarUno();
		insertar();
		todos();
		actualizar();
		borrar();
		
	}
	
	private static void borrar() {
		System.out.println("\n***** Borrar un perfil ******\n");
		Perfil perfil = pDao.findAll().getLast();
		
		System.out.println("Borro el último registro insertado, debe dar uno : " 
				+ pDao.deletebyId(perfil.getIdPerfil()));
		
		System.out.println("Borro el mismo registro, debe dar cero : " 
				+ pDao.deletebyId(perfil.getIdPerfil()));
	}
	
	private static void actualizar() {
		System.out.println("\n***** Actualizar un perfil ******\n");
		Perfil perfil = pDao.findAll().getLast();
		perfil.setNombre("Prueba Actualizacion");
		
		System.out.println("Actualizo el ultimo registro al nombre 'Prueba actualizacion'"
				+ " deb dar 1: " + pDao.update(perfil));
		
		System.out.println("Imprimo el contacto para ver la modificación : " 
				+ pDao.findById(perfil.getIdPerfil()));
	}
	
	private static void insertar() {
		Perfil perfil = new Perfil(5, "Prueba", 57.0);
		
		System.out.println("\n***** Insertar un perfil ******\n");
		System.out.println("Inserto un nuevo perfil, debe dar 1: " + pDao.insert(perfil));
	}
	
	private static void todos() {
		System.out.println("\n***** Busrcar todos los perfiles ******\n");
	
		pDao.findAll().forEach(p -> System.out.println(p));
	}
	
	
	private static void buscarUno() {
		System.out.println("\n***** Bucar uno por id *****\n");
		
		System.out.println("buscando el prfil con id 1: " + pDao.findById(1));
		System.out.println("buscando un id que no existe 199 debe dar null: " + pDao.findById(199));
	}

}
