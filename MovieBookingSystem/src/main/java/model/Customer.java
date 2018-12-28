package model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "Customer")
@PrimaryKeyJoinColumn(name="customerId",referencedColumnName="userId")
@NamedQueries({
	
	@NamedQuery(name="Customer.byUsername" , query = "SELECT c FROM Customer c WHERE c.username=:uname"),
	@NamedQuery(name="Customer.login" , query = "SELECT c FROM Customer c WHERE c.username=:uname and c.password=:pw")
})


public class Customer extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2186315398750271991L;

	

	// private List<Ticket> ticketsBought;
	
	
	
	
}
