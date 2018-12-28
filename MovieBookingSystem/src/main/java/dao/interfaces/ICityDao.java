package dao.interfaces;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.City;

public interface ICityDao extends IReadable<City>, ICreatable<City> {
	
	City readbyName(String cityName);

}
