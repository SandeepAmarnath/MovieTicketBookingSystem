package dao.interfaces.generic;

import model.User;

public interface Authenticator<T extends User> {
	
	boolean isUsernameTaken(String username);

	T register(T t);
	
	T login(String username, String password);
	
	boolean changePassword(T t, String oldPassword, String newPassword);
}
