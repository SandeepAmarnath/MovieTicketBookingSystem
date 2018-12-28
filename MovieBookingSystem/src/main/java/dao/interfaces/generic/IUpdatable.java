package dao.interfaces.generic;

import model.IStorable;


public interface IUpdatable<T extends IStorable> {
	
	boolean update(T t);

}
