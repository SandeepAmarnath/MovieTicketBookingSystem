package runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.City;
import model.User;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieBookingSystem");

		EntityManager em = emf.createEntityManager();

		City lcn = new City().setName("Toronto");
		User user = new User().setUsername("SandeepAmarnath").setFirstName("Sandeep").setLastName("Amarnath")
				.setEmail("sandeep@gmail.com").setPassword("123").setPhoneNumber("54321");

		em.getTransaction().begin();
		em.persist(lcn);
		em.persist(user);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
