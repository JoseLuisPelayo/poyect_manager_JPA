package modelo.dao;

import java.util.List;

import modelo.entities.Perfil;

public class PerfilDaoImplMy8Jpa extends AbsConexionJpa implements PerfilDao {

	public PerfilDaoImplMy8Jpa() {
		super();
	}

	@Override
	public Perfil findById(Integer atributoPk) {

		return em.find(Perfil.class, atributoPk);

	}

	@Override
	public int insert(Perfil refEntidad) {
		try {
			tx.begin();
			em.persist(refEntidad);

			tx.commit();
			filas = 1;
		} catch (Exception e) {
			filas = 0;
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int update(Perfil perfil) {
		try {
			if (findById(perfil.getIdPerfil()) != null) {
				tx.begin();
				em.merge(perfil);
				tx.commit();
				filas = 1;
			} else {
				filas = 0;
			}
		} catch (Exception e) {
			filas = 0;
			e.printStackTrace();
		}

		return filas;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		Perfil p = findById(atributoPk);
		
		try {
			
			if (p != null) {		
				tx.begin();
				em.remove(p);
				tx.commit();
				filas = 1;
			
			} else
				filas = 0;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			filas = -1;
			
		}
		
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> findAll() {
		jpql = "from Perfil p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
