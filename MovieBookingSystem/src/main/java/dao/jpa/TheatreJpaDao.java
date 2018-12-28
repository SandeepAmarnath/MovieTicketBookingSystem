package dao.jpa;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import dao.interfaces.ITheatreDao;
import model.City;
import model.Theatre;

public class TheatreJpaDao implements ITheatreDao{
	
	@Override
	public boolean create(Theatre t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Theatre> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Theatre> list = em.createNamedQuery("Theatre.all",Theatre.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Theatre readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Theatre theatre = em.find(Theatre.class, id);
		em.close();
		return theatre;
	}

	@Override
	public List<Theatre> readbyName(String theatreName) {
		EntityManager em = EMFactory.getEntityManager();
		List<Theatre> list = em.createNamedQuery("Theatre.byName", Theatre.class).setParameter("name", theatreName).getResultList();
		em.close();
		return list;
	}
	
	@Override
	public List<Theatre> readbyNameLike(String theatreLike) {
		EntityManager em = EMFactory.getEntityManager();
		List<Theatre> list = em.createNamedQuery("Theatre.byNameLike",Theatre.class).setParameter("theatreLike", theatreLike).getResultList();
		em.close();
		return list;
		
	}

	@Override
	public Theatre readbyAddress(String theatreAddress) {
		EntityManager em = EMFactory.getEntityManager();
		Theatre theatre = em.createNamedQuery("Theatre.byAddress",Theatre.class).setParameter("address", theatreAddress).getSingleResult();
		em.close();
		return theatre;
	}

	@Override
	public List<Theatre> readByCity(City city) {
		EntityManager em = EMFactory.getEntityManager();
		
		city = new CityJpaDao().readbyName(city.getName());
		if (city==null) {
			return null;
		}
		List<Theatre> list = em.createNamedQuery("Theatre.byCity",Theatre.class).setParameter("city", city).getResultList();
		em.close();
		return list;
	}

}
