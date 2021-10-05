package com.market.market.services.interfaces;
import java.util.ArrayList;


public interface IRepository<T> {

	public ArrayList<T> getAll();
	
	public T get(int id);
}
