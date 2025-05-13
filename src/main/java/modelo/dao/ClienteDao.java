package modelo.dao;


import java.util.List;

import modelo.entities.Cliente;

public interface ClienteDao extends ICrudGenerico<Cliente, String>{
	void exportarClientes(List<Cliente> clientes);
	void importarClientes();
}
