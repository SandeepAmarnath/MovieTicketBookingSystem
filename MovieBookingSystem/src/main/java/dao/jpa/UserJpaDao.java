package dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import dao.interfaces.IUserDao;
import model.User;
import model.UserStatus;

public abstract class UserJpaDao<T extends User> implements IUserDao<T>{
	
//	Calculate the type of T using reflection
	
	@SuppressWarnings("unchecked")
	private final Class<T> clz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];
	
	UserJpaDao() {
	}
	// Removed from IUserDao<T> as unnecessary methods for this type
	// @Override
	// public T readById(int id) {
	// EntityManager em = EMFactory.getEntityManager();
	// T u = em.find(clz, id);
	// em.close();
	// return u;
	// }
	//
	// @Override
	// public List<T> readAll() {
	// return null;
	// }
	//
	// @Override
	// public List<T> readByFirstname(String firstname) {
	// return null;
	// }
	
	
	
	

//	private Class<T> clz;
//	
//	public UserJpaDao(Class<T> clz) {
//		super();
//		this.clz=clz;
//	}
	
	
	@Override
	public boolean create(T t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();		
		em.close();
		return true;
	}

	@Override
	public boolean update(T t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return false;
	}

	@Override
	public boolean delete(T t) {
		// Do we delete record from DB or set status flag to 'DELETED'?
		// -> It's generally recommended not to delete information from the
		// database unless it really is throwaway information

		t.setUserStatus(UserStatus.DELETED);
		return update(t);
		
	}

	@Override
	public T readByUsername(String username) {
		String queryName = String.format("%s.byUsername", clz.getSimpleName());
//		String queryName = String.format("SELECT a FROM %s WHERE a.username = :uname", this.clz.getSimpleName());
		EntityManager em = EMFactory.getEntityManager();
		T user;
		try{
			user = em.createNamedQuery(queryName, clz).setParameter("uname", username).getSingleResult();
		}
		catch(NoResultException e){
			user=null;
		}
		em.close();
		return user;
	}

	@Override
	public T readByEmail(String email) {
		String query = String.format("SELECT a FROM %s a WHERE a.email = :email", this.clz.getSimpleName());
		
		EntityManager em = EMFactory.getEntityManager();
		T user = null;
		try{
			user = em.createQuery(query,clz).setParameter("email", email).getSingleResult();
		}
		catch(NoResultException e){
			
		}
		
		em.close();
		return user;
	}

	@Override
	public T register(T t) {
		if(create(t)){
			return t;
		}
		return null;
	}

	@Override
	public T login(String username, String password) {
		String queryName = String.format("%s.login", clz.getSimpleName());
		EntityManager em = EMFactory.getEntityManager();
		T user = null;
		try {
			user = em.createNamedQuery(queryName, clz).setParameter("uname", username).setParameter("pw", password)
					.getSingleResult();

		} catch (NoResultException e) {
			user = null;
		}
		em.close();
		return user;
	}

	@Override
	public boolean changePassword(T t, String oldPassword, String newPassword) {
		T found = login(t.getUsername(), oldPassword);
		if (found != null) {
			found.setPassword(newPassword);
			return update(found);
		}
		return false;
	}



	@Override
	public boolean isUsernameTaken(String username) {
		return readByUsername(username) != null;
	}
	




}
