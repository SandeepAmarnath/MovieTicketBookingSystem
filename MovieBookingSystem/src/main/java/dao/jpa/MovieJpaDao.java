package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.interfaces.IMovieDao;
import model.Movie;

public class MovieJpaDao implements IMovieDao{
	
	@Override
	public boolean create(Movie movie) {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<Movie> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Movie> list = em.createNamedQuery("Movie.all",Movie.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Movie readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Movie movie = em.find(Movie.class, id);
		em.close();
		return movie;
	}

	@Override
	public Movie readByName(String str) {
		EntityManager em = EMFactory.getEntityManager();
		Movie movie = em.createNamedQuery("Movie.byName",Movie.class).setParameter("name", str).getSingleResult();
		em.close();
		return movie;
	}


	@Override
	public List<Movie> readByName_Like(String str) {
		EntityManager em = EMFactory.getEntityManager();
		List<Movie> list = em.createNamedQuery("Movie.byNameLike",Movie.class).setParameter("name","%"+ str +"%").getResultList();
		em.close();
		return null;
	}

	
	@Override
	public List<Movie> readByKidsMovies() {
		EntityManager em = EMFactory.getEntityManager();
		List<Movie> list = em.createNamedQuery("Movie.byKids",Movie.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Movie> readByRating(double rating) {
		EntityManager em = EMFactory.getEntityManager();
		List<Movie> list = em.createNamedQuery("Movie.byRating", Movie.class).setParameter("rating", rating).getResultList();
		em.close();
		return list;
	}

}
