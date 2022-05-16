package com.market.market.services.interfaces;
import java.util.ArrayList;


public interface IRepository<T> {

	public ArrayList<T> getAll();
	
	public T get(int id);
	
	public void add(T element);
	
	public T update(int id, T element) throws Exception;
	
	public void remove(int id) throws Exception;
	
	public boolean isValid(T element);
}
