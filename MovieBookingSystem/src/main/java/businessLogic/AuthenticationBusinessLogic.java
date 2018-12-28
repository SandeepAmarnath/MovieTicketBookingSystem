package businessLogic;

import dao.interfaces.generic.Authenticator;
import exceptions.UserDataException;
import model.Admin;
import model.Customer;
import model.User;
import model.UserStatus;

public class AuthenticationBusinessLogic<T extends User> {

	// TODO: explain the Resource annotation in a few weeks
	// @Resource(name="userDao")
	private Authenticator<T> authDao;
	private Class<T> clz;

	public AuthenticationBusinessLogic(Class<T> clz) {
		super();
		this.clz = clz;
	}

	public void setAuthDao(Authenticator<T> authDao) {
		this.authDao = authDao;
	}

	public T register(String username,String mobile, String password, String firstname, String lastname, String email, int age)
			throws UserDataException {
		T t = getUserSubtype();

		if (authDao.isUsernameTaken(username))
			throw new UserDataException("Username is not unique");
		try {
			// Note: delegated validation to the User object itself, will get
			// IllegalArgumentException if any aspect of data validation is
			// broken
			t.setUsername(username).setPassword(password).setFirstName(firstname).setLastName(lastname).setEmail(email)
					.setUserStatus(UserStatus.ACTIVE).setAge(age).setPhoneNumber(mobile);

			t = authDao.register(t);

		} catch (RuntimeException e) {
			throw new UserDataException(e);
		}

		return t;
	}

	public User login(String username, String password) {
		if (username == null || username.length() == 0 || username.length() > 20 || password == null
				|| password.length() < 2)
			return null;

		return authDao.login(username, password);
	}

	public boolean changePassword(User user, String oldPw, String newPw, String confPw) throws UserDataException {
		// TODO: A number of validation checks
		return false;
	}

	@SuppressWarnings("unchecked")
	private T getUserSubtype() {
		if (clz == Customer.class)
			return (T) new Customer();
		else if (clz == Admin.class)
			return (T) new Admin();
		else
			throw new IllegalArgumentException("Invalid User subtype");
	}

}
