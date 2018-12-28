package model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "Admin")
@PrimaryKeyJoinColumn(name = "adminId", referencedColumnName = "userId")
@NamedQueries({
	@NamedQuery(name="Admin.byUsername" , query="SELECT a FROM Admin a WHERE a.username = :uname"),
	@NamedQuery(name="Admin.login" , query="SELECT a FROM Admin a WHERE a.username = :uname and a.password = :pw")
})
public class Admin extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974401535925597334L;

	

}
