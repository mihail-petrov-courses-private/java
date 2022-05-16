package com.netitjava.level.manager;

//import com.netitjava.level.child.BasicLevel;
//import com.netitjava.level.child.HardLevel;
//import com.netitjava.level.child.NormalLevel;
import com.netitjava.level.child.*;
import com.netitjava.level.parent.Level;

public class LevelManager {

	public static final String EASY_LEVEL	= "easy";
	public static final String NORMAL_LEVEL = "normal";
	public static final String HARD_LEVEL 	= "hard";
	
	public static Level bootstrap(String dificulty) {
		
		if(dificulty.equals(EASY_LEVEL) ) {
			return new BasicLevel();	
		}
		
		if(dificulty.equals(NORMAL_LEVEL)) {
			return new NormalLevel();
		}		
		
		if(dificulty.equals(HARD_LEVEL)) {
			return new HardLevel();
		}
		
		return new NormalLevel();
	}
}
