package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public interface EmpleadoDao extends ICrudGenerico<Empleado, Integer>{
	List<Empleado> empleadosByDepartamento(int idDepar);
	List<Empleado> empleadosByGenero(char genero);
	List<Empleado> empleadosByApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);
	List<Empleado> empleadosByIdPerfil(int idPerfil);
}
