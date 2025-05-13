package test.dao;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplJpa;
import modelo.entities.Cliente;
import java.math.BigDecimal;

public class TestClientes {

	public static void main(String[] args) {
		ClienteDao cdao = new ClienteDaoImplJpa();
		//Cliente clienteNuevo = new Cliente("C44444444", "Carstairs", "Madrid", 15651357.05, "Zaybe", 356);
		Cliente clienteNuevo = new Cliente();
		clienteNuevo.setCif("C55555555");
		clienteNuevo.setApellidos("Martos");
		clienteNuevo.setDomicilio("Madrid");
		clienteNuevo.setNombre("Gema");
		clienteNuevo.setNumeroEmpleados(12546852);
		clienteNuevo.setFacturacionAnual(200000000.00);
		
		
		 System.out.println(cdao.findById("C44444444"));
		
		 cdao.findAll().forEach(System.out::println);
		
		 cdao.insert(clienteNuevo);
		
		 cdao.findAll().forEach(System.out::println);
		
		  cdao.deletebyId("C44444444");
	
		 cdao.exportarClientes(cdao.findAll());
		
		cdao.importarClientes();
		
		System.out.println("FIN DE PROCESO");
		
	}
	

}
