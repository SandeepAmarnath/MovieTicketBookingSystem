package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IScreenDao;
import model.Screen;
import model.Theatre;

public class ScreenJpaDoa implements IScreenDao{

	@Override
	public boolean create(Screen t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	@Override
	public List<Screen> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Screen> list = em.createNamedQuery("Screen.all",Screen.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Screen readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Screen screen = em.find(Screen.class, id);
		em.close();
		return screen;
	}

	@Override
	public boolean update(Screen t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		return true;
	}

//	These may not be required, but not sure!!
//	@Override
//	public List<Screen> getCapacity(int screenCapacity) {
//		EntityManager em = EMFactory.getEntityManager();
//		List<Screen> list = em.create
//		return null;
//	}

//	@Override
//	public List<Screen> getScreensByTheatre(Theatre threatre) {
//		
//		return null;
//	}

}
