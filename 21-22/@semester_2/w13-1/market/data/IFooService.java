package com.market.market.data;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public interface IFooService {

	public ArrayList<Foo> findAll();
	
}
