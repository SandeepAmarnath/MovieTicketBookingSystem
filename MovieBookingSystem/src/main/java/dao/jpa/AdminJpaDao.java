package dao.jpa;

import model.Admin;


public class AdminJpaDao extends UserJpaDao<Admin>{

	//Parent type is using reflection to work out the type of T, but we still want to make the constructor less visible
	
	public AdminJpaDao() {

		// TODO Auto-generated constructor stub
	}
	

}
