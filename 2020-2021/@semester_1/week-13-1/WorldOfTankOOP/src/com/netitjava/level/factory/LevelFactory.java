package com.netitjava.level.factory;

//import com.netitjava.level.child.BasicLevel;
//import com.netitjava.level.child.HardLevel;
//import com.netitjava.level.child.NormalLevel;
import com.netitjava.level.child.*;
import com.netitjava.level.parent.Level;

public class LevelFactory {

	public static final String EASY_LEVEL	= "easy";
	public static final String NORMAL_LEVEL = "normal";
	public static final String HARD_LEVEL 	= "hard";
	
	public static Level bootstrap(String dificulty) {
		
		if(dificulty.equals(EASY_LEVEL) ) {
			return new BasicLevel();	
		}
		
		return new BasicLevel();
	}
}
