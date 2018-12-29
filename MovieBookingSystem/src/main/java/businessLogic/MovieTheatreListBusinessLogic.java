package businessLogic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import dao.jpa.EMFactory;
import dao.jpa.MovieJpaDao;
import model.Movie;

public class MovieTheatreListBusinessLogic {
	
	
	public static void main(String[] args) {
		getShowTime();
	}
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
				if (! movieTheatre.get((String)objects[0]).contains((String)objects[1])) {
					movieTheatre.get((String)objects[0]).add((String)objects[1]);
				}
				
			}
			
			
			
		}
		
		
//		movieTheatre.put(key, value)
		
		
		
		
//		System.out.println(movieTheatre);
		
		em.getTransaction().commit();
		em.close();
		
		return movieTheatre;
	}
	
	
	public static void getShowTime() {
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
	
		
		String vari = "Jumanji";
		Query q = em.createNativeQuery("select sh.show_id,m.MOVIE_NAME,t.THEATRE_NAME,s.SCREEN_ID,s.CAPACITY,sh.show_time FROM screen s "
									  + "JOIN show sh ON sh.screen_id=s.screen_id "
									  + "JOIN movie m ON sh.movie_id=m.movie_id "
									  + "JOIN theatre t ON t.theatre_id=s.theatre_id where m.movie_name=?1");
		q.setParameter(1, vari);
		
		List<Object[]> all = q.getResultList();
		
		for (Object[] objects : all) {
			ArrayList<String> strArray = new ArrayList<String>();
			System.err.println((BigDecimal)objects[0]+ "      "+(String)objects[1]+ "      "+(String)objects[2]+ "      "+(BigDecimal)objects[3]+ "      "+(BigDecimal)objects[4]+"         "+(Timestamp)objects[5]);
	}

 }
}
