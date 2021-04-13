package com.netitjava.units.parent;

import com.netitjava.model.RowCol;

public abstract class Player extends Unit {

	public void move(RowCol cordinates) {

		this.setRow(cordinates.getRow());
		this.setCol(cordinates.getCol());
	}	
	
	public abstract RowCol getDestination(String keyCode);
}
