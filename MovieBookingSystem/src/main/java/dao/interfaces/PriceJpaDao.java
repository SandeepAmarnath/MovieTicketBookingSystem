package dao.interfaces;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import dao.jpa.EMFactory;
import model.Price;
import model.Theatre;

public class PriceJpaDao implements IPriceDao{

	@Override
	public boolean create(Price t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	
	@Override
	public List<Price> readAll() {
		EntityManager em = EMFactory.getEntityManager();
		List<Price> list = em.createNamedQuery("Price.all",Price.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Price readby(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Price price = em.find(Price.class, id);
		em.close();
		return price;
	}

	@Override
	public boolean update(Price t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean delete(Price t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.detach(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Price> getPeakratePrices() {
		EntityManager em = EMFactory.getEntityManager();
		BooleanAttributeConverter bool = new BooleanAttributeConverter();
		Character peak = bool.convertToDatabaseColumn(true);
		List<Price> list = em.createNamedQuery("Price.byPeakRate",Price.class).setParameter("peak", peak).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Price> getDiscountedPrices() {
		EntityManager em = EMFactory.getEntityManager();
		BooleanAttributeConverter bool = new BooleanAttributeConverter();
		Character discounted = bool.convertToDatabaseColumn(true);
		List<Price> list = em.createNamedQuery("Price.bydiscountedRate",Price.class).setParameter("discounted", discounted).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Price> getEnhancedPrices() {
		EntityManager em = EMFactory.getEntityManager();
		BooleanAttributeConverter bool = new BooleanAttributeConverter();
		Character enhanced = bool.convertToDatabaseColumn(true);
		List<Price> list = em.createNamedQuery("Price.byenhancedRate",Price.class).setParameter("enhanced", enhanced).getResultList();
		em.close();
		return list;
	}

//	Price doesn't have Theatre. Bidirectional relationship necessary? Not sure!!
//	@Override
//	public List<Price> getPricesByTheatre(Theatre theatre) {
//		EntityManager em = EMFactory.getEntityManager();
//		List<Theatre> 
//		em.close();
//		return null;
//	}

	@Override
	public List<Price> getPricesByPrice(double price) {
		EntityManager em = EMFactory.getEntityManager();
		List<Price> list = em.createNamedQuery("Price.byPrice" , Price.class).setParameter("price", price).getResultList();
		em.close();
		return list;
	}
	

}
