package com.market.market.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class FooService implements IFooService {

	private ArrayList<Foo> collection;
	
	public FooService() {
		this.collection = new ArrayList<>();
		this.collection.add(new Foo("Mihail"));
	}
	
	public ArrayList<Foo> findAll() {
		return this.collection;
	}
}
