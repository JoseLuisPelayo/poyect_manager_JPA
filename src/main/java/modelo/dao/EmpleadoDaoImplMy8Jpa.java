package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public class EmpleadoDaoImplMy8Jpa extends AbsConexionJpa implements EmpleadoDao {

	public EmpleadoDaoImplMy8Jpa() {
		super();
	}

	public Empleado findById(Integer id) {
		return em.find(Empleado.class, id);
	}

	public int insert(Empleado empl) {
		try {

			tx.begin();
			em.persist(empl);
			tx.commit();
			filas = 1;
			
		} catch (Exception e) {
			filas = 0;
		}

		return filas;
	}

	public int update(Empleado empl) {
		try {

			if (findById(empl.getIdEmpl()) != null) {

				tx.begin();
				em.merge(empl);
				tx.commit();
				filas = 1;

			} else
				filas = 0;

		} catch (Exception e) {
			filas = -1;
		}

		return filas;
	}

	public int deleteById(Integer id) {
		Empleado empl = findById(id);

		try {
			if (empl != null) {

				tx.begin();
				em.remove(empl);
				tx.commit();
				filas = 1;

			} else
				filas = 0;
			
		} catch (Exception e) {
			filas = -1;
		}

		return filas;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> findAll() {
		jpql = "from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> empleadosByDepartamento(int id) {
		jpql = "from Empleado e where e.departamento.idDepar = :id";
		query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> empleadosByGenero(char gen) {
		jpql = "from Empleado e where e.genero = :genero";
		query = em.createQuery(jpql);

		Character str = gen;
		query.setParameter("genero", str.toString());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql = "from Empleado e where e.apellidos like :sub";
		query = em.createQuery(jpql);
		query.setParameter("sub", "%" + subcadena + "%");
		return query.getResultList();
	}

	public double salarioTotal() {
		jpql = "select sum(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		
		Double res = (Double) query.getSingleResult();
		
		return (res == null) ? 0.0 : res;
	}

	public double salarioTotal(int idDepartamento) {
		jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepar like :id";
		query = em.createQuery(jpql);
		query.setParameter("id", "%" + idDepartamento + "%");
		
		Double res = (Double) query.getSingleResult();
		
		return (res == null) ? 0.0 : res;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> empleadosByIdPerfil(int id) {
		jpql = "from Empleado e where e.perfil.idPerfil = :id";
		query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}
}