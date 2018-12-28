package dao.interfaces;

import java.util.List;


import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;

import model.City;
import model.Theatre;
import model.User;

public interface ITheatreDao extends IReadable<Theatre>, ICreatable<Theatre> {

	List<Theatre> readbyNameLike(String theatreLike);
	
	List<Theatre> readbyName(String theatreName);

	Theatre readbyAddress(String theatreAddress);

	List<Theatre> readByCity(City city);

}
