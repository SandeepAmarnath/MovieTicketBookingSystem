package dao.interfaces.generic;

import model.IStorable;

public interface ICreatable<T extends IStorable>{

	boolean create(T t);
}
