package dao.jpa;

import model.Customer;


public class CustomerJpaDao extends UserJpaDao<Customer>{

	
	//Parent type is using reflection to work out the type of T, but we still want to make the constructor less visible
	
	public CustomerJpaDao() {
		// TODO Auto-generated constructor stub
	}
	

}
