package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public class DepartamentoDaoImplMy8Jpa extends AbsConexionJpa implements DepartamentoDao {

	@Override
	public Departamento findById(Integer atributoPk) {

		return em.find(Departamento.class, atributoPk);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findAll() {
		jpql = "from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public int insert(Departamento departamento) {
		try {
			tx.begin();
			em.persist(departamento);
			tx.commit();
			filas = 1;
		} catch (Exception e) {
			filas = 0;
		}

		return filas;
	}

	@Override
	public int update(Departamento departamento) {

		try {
			if (findById(departamento.getIdDepar()) != null) {
				tx.begin();
				em.merge(departamento);
				tx.commit();
				filas = 1;
			}
		} catch (Exception e) {
			filas = 0;
		}

		return filas;
	}

	@Override
	public int deleteById(Integer id) {
		Departamento d = findById(id);

		try {
			if (d != null) {

				tx.begin();
				em.remove(d);
				tx.commit();
				filas = 1;

			} else

				filas = 0;

		} catch (Exception e) {
			filas = -1;
		}

		return filas;
	}

}
