package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.Authenticator;
import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.User;


//Can be either "Admin" or "Customer", hence using generics. T will be replaced by specific user (admin or customer). 

public interface IUserDao<T extends User> extends /*IReadable<T>*/ ICreatable<T>, IUpdatable<T>, IDeletable<T> , Authenticator<T> {
   
	
	T readByUsername(String username);
	
	T readByEmail(String email);
	

}

