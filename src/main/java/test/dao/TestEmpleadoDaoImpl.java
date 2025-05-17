package test.dao;

import java.time.LocalDate;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entities.Empleado;

public class TestEmpleadoDaoImpl {

	private static EmpleadoDao eDao;
	private static DepartamentoDao dDao;
	private static PerfilDao pDao;
	
	static {
		
		eDao = new EmpleadoDaoImplMy8Jpa();
		dDao = new DepartamentoDaoImplMy8Jpa();
		pDao = new PerfilDaoImplMy8Jpa();
		
	}
	
	public static void main(String[] args) {
		
		uno();
		todos();
		insertar();
		actualizar();
		borrar();
		porDepartamento();
		porGenero();
		porApellido();
		salarioTotal();
		salarioPorDapartamento();
		porPerfil();
		
	}
	
	private static void porPerfil() {
		System.out.println("\nBusco por el perfil");
		eDao.empleadosByIdPerfil(4).stream().forEach(System.out::println);
	}
	
	private static void salarioPorDapartamento() {
		System.out.println("\nSalario total del departamento 20, tiene que dar 193000 = "
						+ eDao.salarioTotal(20));
	}
	
	private static void salarioTotal() {
		System.out.println("\nSalario total tiene que dar 328000 = " + eDao.salarioTotal());
	}
	
	private static void porApellido() {
		System.out.println("\nBusco por el apellido ");
		eDao.empleadosByApellido("o").stream().forEach(System.out::println);
	}
	
	private static void porGenero() {
		System.out.println("\nBusco por el genero H");
		eDao.empleadosByGenero('h').stream().forEach(System.out::println);
		}
	
	private static void porDepartamento() {
		System.out.println("\nBusco por el departamento 10");
		eDao.empleadosByDepartamento(10).stream().forEach(System.out::println);
	}
	
	private static void actualizar() {
		System.out.println("\nActualizar");
		Empleado empl = eDao.findAll().getLast();
		empl.setNombre("Caracola");
		
		System.out.println("Modifico el ultimo que inserte, debe dar 1: " + eDao.update(empl));
		System.out.println("Le puse de nombre Caracola : " + eDao.findById(empl.getIdEmpl()));
	}
	
	private static void borrar() {
		System.out.println("\nBorrar");
		int id = eDao.findAll().getLast().getIdEmpl();
		System.out.println("Borro el que acabo de insertar, debe dar 1: " 
					+ eDao.deleteById(id));
		System.out.println("Borro el mismo debe dar 0: " + eDao.deleteById(id));
	}
	
	private static void insertar() {
		System.out.println("\nInsertar");
		Empleado emp = new Empleado(1,
							"Jose",
							"jose@mail.com",
							LocalDate.of(2025, 4, 22),
							LocalDate.of(2025, 4, 23),
							"H",
							"jose",
							"1234",
							125.5,
							dDao.findById(40),
							pDao.findById(1));
		
		System.out.println(" Inserto un nuevo departamento, debe dar: " + eDao.insert(emp));
	}
	
	private static void uno() {
		System.out.println("\nBuscar Uno");
		System.out.println("Busco uno existente : " + eDao.findById(100));
		System.out.println("Busco uno que no existe debe dar null : " + eDao.findById(9999999));
	}
	
	private static void todos() {
		System.out.println("\nBusco Todos");
		eDao.findAll().stream().forEach(System.out::println);
	}
	

}
