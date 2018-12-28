package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ICityDao;
import model.City;


public class CityJpaDao implements ICityDao{

	
	@Override
	public boolean create(City t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	
	@Override
	public List<City> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<City> list = em.createNamedQuery("City.all",City.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public City readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		City city = em.find(City.class, id);
		em.close();
		return city;
	}

	
	@Override
	public City readbyName(String cityName) {
		EntityManager em = EMFactory.getEntityManager();
		City city = em.createNamedQuery("City.readbyName", City.class).setParameter("name", cityName).getSingleResult();
		em.close();
		return city;
	}
	
	

}
