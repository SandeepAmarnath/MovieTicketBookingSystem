package dao.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IShowDao;
import model.Movie;
import model.Screen;
import model.Show;

public class ShowJpaDao implements IShowDao{

	

	@Override
	public boolean create(Show t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	
	@Override
	public List<Show> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Show> list = em.createNamedQuery("Show.all",Show.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Show readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Show show = em.find(Show.class, id);
		em.close();
		return show;
	}


	@Override
	public boolean update(Show t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean delete(Show t) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.detach(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Show> getShowbyShowTime(LocalDateTime showTime) {
		EntityManager em = EMFactory.getEntityManager();
		List<Show> list = em.createNamedQuery("Show.byShowTime",Show.class).setParameter("time",showTime).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Show> getShowsbyMovie(Movie movie) {
		EntityManager em = EMFactory.getEntityManager();
		List<Show> list = em.createNamedQuery("Show.byMovie",Show.class).setParameter("movie",movie).getResultList();
		em.close();
		return list;
	}
// Not able to use this bcoz there is no screen parameter in Show class. Since the Screen has a show parameter, the Show doesnt have a Screen. 
	//TODO:  Try to resolve this
//	@Override
//	public List<Show> getShowsbyScreen(Screen screen) {
//		EntityManager em = EMFactory.getEntityManager();
//		List<Show> list = em.createNamedQuery("Show.byScreen",Show.class).setParameter("screen",screen).getResultList();
//		em.close();
//		return list;
//	}

}
