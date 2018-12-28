package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.Movie;
import model.Screen;
import model.Theatre;

public interface IScreenDao extends IReadable<Screen>, ICreatable<Screen>, IUpdatable<Screen>{
	
//	List<Screen> getCapacity(int screenCapacity); //May be this is not necessary
	
//	List<Screen> getScreensByTheatre(Theatre threatre);//May be this is not necessary. This has the same problem as the Show. There is no theatre in Screen 
//														class. But Screen is in theatre class. So not sure whether it requires a bidirectional relationship
	
	
}
