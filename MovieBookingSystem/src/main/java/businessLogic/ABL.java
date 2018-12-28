package businessLogic;

import dao.jpa.CustomerJpaDao;
import model.Customer;

public class ABL {
	
	public boolean login(String username, String password){
		CustomerJpaDao cust = new CustomerJpaDao();
		Customer customer = cust.login(username, password);
		System.err.println(customer);
		if (customer!=null) {
			
			return true;
			
		}
		return false;
	}

}
