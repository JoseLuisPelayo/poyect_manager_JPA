package principales;

import java.util.Scanner;



import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplJpa;
import modelo.entities.Cliente;

public class GestionClientes {

private static ClienteDao cdao;
private static Scanner leer;
private static Cliente cliente1;
private static Cliente cliente2;
	static{
		cdao = new ClienteDaoImplJpa();
		leer = new Scanner(System.in);
		cliente1= new Cliente( );
		cliente2= new Cliente( );
	}
	public static void main(String[] args) {
		//CLIENTE 1
		cliente1.setFacturacionAnual(400000.00);
		cliente1.setApellidos("Lauren");
		cliente1.setDomicilio("Barcelona");
		cliente1.setNumeroEmpleados(500);
		cliente1.setNombre("Laura");
		cliente1.setCif("128931983");
		
		//CLIENTE 2
		cliente2.setFacturacionAnual(500000.00);
		cliente2.setApellidos("Zayne");
		cliente2.setDomicilio("Corea del Sur");
		cliente2.setNumeroEmpleados(900);
		cliente2.setNombre("Li");
		cliente2.setCif("128931984");
		
		int opcion;
	
		do {
		opcion = pintarMenu();
		switch (opcion) {
			case 1:
				altaCliente(cliente1);
				break;
			case 2:
				buscarUno();
				break;
			case 3:
				buscarTodos();
				break;
			case 4:
				eliminarCliente();
				break;
			case 5:
				exportarCliente();
				break;
			case 6:
				importarCliente();
			default:
				break;
				
		}
	
	} while (opcion != 7);
		
	leer.close();
	
	System.out.println("PROGRAMA TERMINADO");
	}
	

	public static int pintarMenu() {
		int opcion = 0;
		System.out.println("1.- Alta Cliente");
		System.out.println("2.- Buscar un Cliente");
		System.out.println("3.- Buscar todos");
		System.out.println("4.- Eliminar el Cliente");
		System.out.println("5.- Exporter cliente");
		System.out.println("6.- Importar cliente");
		System.out.println("7.- Salir");

		opcion=leer.nextInt();
		
		while (opcion<1 || opcion>8) {
			System.out.println("Solo del 1 al 7");
			opcion=leer.nextInt();
		}
		
		return opcion;
	}

		//ALTA DE CLIENTE
		public static void altaCliente(Cliente cliente) {
		leer.nextLine();
		System.out.println("teclea el cif del cliente");
		
		String cif = leer.nextLine();
			
		System.out.println("teclea el nombre del cliente");
		String nombre = leer.nextLine();
			
		System.out.println("teclea el apellidos del cliente");
		String apellidos = leer.nextLine();
			
		
		System.out.println("teclea el domicilio del cliente");
		String domicilio = leer.nextLine();
			
		
		System.out.println("teclea la cantidad(numeros)facturacionAnual del cliente");
		double facturacionAnual = leer.nextDouble();
			
		System.out.println("teclea el numero de empleados del cliente");
		int numeroEmpleados = leer.nextInt();
				
		Cliente nuevoCliente = new Cliente(cif, apellidos, domicilio, facturacionAnual, nombre, numeroEmpleados);
			if(cdao.insert(nuevoCliente) == 0)
				System.out.println("Cliente ya existe.");
			else
				System.out.println("Cliente dado de alta con exito" + nuevoCliente);

		}
		
		//BURCAR UN CLIENTE POR CIF
		public static void buscarUno() {
			System.out.println("Introduce el cif del cliente ('A22222222')");
			String cif = leer.next();
			if(cdao.findById(cif) != null)
				System.out.println(cdao.findById(cif));
			else
				System.out.println("El cif introducido no se corresponde a ningun cliente");
		}
		
		//BUSCAR TODOS
		public static void buscarTodos() {
			cdao.findAll().forEach(System.out::println);
		}
		
		//ELIMINAR UN CLIENTE
		public static void eliminarCliente() {
			System.out.println("Introduce el cif del cliente que qieres eliminar ('128931983')");
			String cif = leer.next();
			
			if(cdao.findById(cif) != null)
				switch(cdao.deletebyId(cif)){
				case 0: 
					System.out.println("El cif introducido no se corresponde a ningun cliente");
					break;
				case 1:
					System.out.println("Cliente eliminado con exito");
					break;
				case -1:
					System.out.println("Error en eliminar Cliente");
				}
			else
				System.out.println("El cif introducido no se corresponde a ningun cliente");
		}
		
		//IMPORTAR UN UN FICHERO CON CLIENTES
		public static void importarCliente() {
			cdao.importarClientes();
		}
		
		//EXPORTAR UN FICHERO CON CLIENTES
		public static void exportarCliente() {
			cdao.exportarClientes(cdao.findAll());
		}
}
