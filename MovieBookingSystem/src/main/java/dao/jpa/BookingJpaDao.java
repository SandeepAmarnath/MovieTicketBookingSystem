package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IBookingDao;
import dao.interfaces.PriceJpaDao;
import model.Booking;
import model.Price;
import model.Show;
import model.User;

public class BookingJpaDao implements IBookingDao{

	@Override
	public boolean create(Booking t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
		
	}

	@Override
	public List<Booking> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Booking> list = em.createNamedQuery("Booking.all",Booking.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Booking readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Booking booking = em.find(Booking.class, id);
		em.close();
		return booking;
	}

	@Override
	public boolean update(Booking t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean delete(Booking t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.detach(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		EntityManager em = EMFactory.getEntityManager();
		
		//Confirm whether its correct!
		user = new CustomerJpaDao().readByUsername(user.getUsername());
		
		if (user == null) {
			return null;
		}
		List<Booking> list = em.createNamedQuery("Booking.byUser",Booking.class).setParameter("user", user).getResultList();
		
		em.close();
		return list;
	}

	@Override
	public List<Booking> getBookingsByNumTickets(int numTickets) {
		EntityManager em = EMFactory.getEntityManager();
		List<Booking> list = em.createNamedQuery("Booking.byNumTickets" , Booking.class).setParameter("number", numTickets).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Booking> getBookingsByPrice(Price price) {
		
		EntityManager em = EMFactory.getEntityManager();
		
		List<Price> prices = new PriceJpaDao().getPricesByPrice(price.getPrice());
		
		
		//Check this if its right
		if (!prices.contains(price)) {
			return null;
		}
		
		List<Booking> list = em.createNamedQuery("Booking.byPrice" , Booking.class).setParameter("price", price).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Booking> getBookingsByShow(Show show) {
		
		EntityManager em = EMFactory.getEntityManager();
		
		show  = new ShowJpaDao().readby(show.getShowId());
		
		if (show==null) {
			return null;
		}
		List<Booking> list = em.createNamedQuery("Booking.byShow" , Booking.class).setParameter("show", show).getResultList();
		
		
		return list;
	}
	
	

}
