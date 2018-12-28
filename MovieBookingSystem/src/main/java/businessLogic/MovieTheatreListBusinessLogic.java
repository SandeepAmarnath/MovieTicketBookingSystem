package businessLogic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import dao.jpa.EMFactory;
import dao.jpa.MovieJpaDao;
import model.Movie;

public class MovieTheatreListBusinessLogic {
	
	
	public List<Movie> getMovies() {
		MovieJpaDao movieJpaDao = new MovieJpaDao();
		List<Movie> allMovies = movieJpaDao.readAll();
		return allMovies;
		
	}
	
	public HashMap<String,ArrayList<String>> getMoviesAndTheatreList() {
		
		HashMap<String,ArrayList<String>> movieTheatre=new HashMap<String,ArrayList<String>>(); 
		
		
		
		
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		
		
		Query q = em.createNativeQuery("select m.movie_name,t.theatre_name,s.capacity from theatre t "
				+ "join screen s on s.theatre_id=t.theatre_id "
				+ "join show sh on sh.screen_id = s.screen_id "
				+ "join movie m on m.movie_id=sh.movie_id order by m.movie_name");
		
		List<Object[]> all = q.getResultList();
		
		for (Object[] objects : all) {
			ArrayList<String> strArray = new ArrayList<String>();
			System.err.println((String)objects[0]+ "      "+(String)objects[1]);
			
			
			
			if (! movieTheatre.containsKey((String)objects[0])) {
				
				movieTheatre.put((String)objects[0], strArray);
				strArray.add((String)objects[1]);
				
			}
			
			else {
				movieTheatre.get((String)objects[0]).add((String)objects[1]);
			}
			
			
			
		}
		
		
//		movieTheatre.put(key, value)
		
		
		
		
//		System.out.println(movieTheatre);
		
		em.getTransaction().commit();
		em.close();
		
		return movieTheatre;
	}

}
