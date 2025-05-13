package modelo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import modelo.entities.Cliente;


public class ClienteDaoImplJpa extends AbsConexionJpa implements ClienteDao{

	@Override
	public Cliente findById(String cif) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, cif);
	}

	@Override
	public int insert(Cliente cliente) {
		filas = 0;
		try {
		tx.begin();
			em.persist(cliente);
		tx.commit();
		filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		
		return filas;
	}


	@Override
	public int deletebyId(String cif) {
		filas = 0;
		Cliente cliente = null;
		try {
		
		cliente = findById(cif);
		if(cliente != null){
			tx.begin();
			em.remove(cliente);
			tx.commit();
			filas = 1;}
		else {
			filas = 0;}
		}catch(Exception e) {
			System.err.println("Error en eliminar Cliente");
			filas = -1;
		}
		
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		jpql = "from Cliente c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}


	@Override
	public void exportarClientes(List<Cliente> clientes) {

		String ficheroFuente = "clientes.obj";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try  {
			oos = new ObjectOutputStream(new FileOutputStream(ficheroFuente));
			for (Cliente ele: findAll())
				oos.writeObject(ele);
		    System.out.println("Exportacion realizada con exito");
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("Exportacion no realizada");
		}
		
		System.out.println("Clientes exportados correctamente");
		
	}

	@Override
	public void importarClientes() {
		String ficheroFuente = "clientes.obj";
		Cliente cliente = null;		
	
		 try  {
			 FileInputStream fis = new FileInputStream(ficheroFuente);
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         while(true) {
	        	 cliente =  (Cliente) ois.readObject();
	        	 System.out.println(cliente);
	         } 
		        
		 }catch(EOFException e) {
			 System.out.println("Fin de lectura de objetos, proceso terminado");
		 }
	       catch (FileNotFoundException e ) {
		            System.out.println("Error: No se encontró el archivo " + ficheroFuente);}

		 catch (ClassNotFoundException | IOException e) {
		                System.out.println("Error: Clase Cliente no encontrada.");
		            }
		}

	@Override
	public int update(Cliente refEntidad) {
		filas = 0;
	    try {
	    tx.begin();
	        	em.merge(refEntidad);
	    tx.commit();
	    filas = 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        filas = 0;
	    }
	    return filas;
	}



}

