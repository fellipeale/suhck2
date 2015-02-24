package br.ufpr.ees.suhck2.service;

import java.util.List;

public interface ServiceBase<T> {

	void save(T object);
	
	T read(int id);
	
	void edit(T object);
	
	void delete(Integer id);
	
	List<T> listAll();
	
}
