package br.ufpr.ees.suhck2.persistence;

import java.util.List;

public interface DAOBase<T> {

	void create(T object);
	
	T read(Integer id);
	
	void update(T object);
	
	void delete(Integer id);
	
	List<T> list();
	
}
