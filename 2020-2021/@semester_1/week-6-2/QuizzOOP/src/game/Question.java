package game;

// import all
import util.*;

// import single entity
// import util.Console;
// import util.Transform;

public class Question {
	
	// content
	public String content;
	
	// comlexity
	public int complexity;
	
	public Answer[] collection;

	public void render() {
		
		String content = "Нов въпрос";
		
		Console.log("Въпроса е ? ");
		Console.log(this.content);

		// Default loop concept 
		for(int i = 0; i < this.collection.length; i++) {
			
			Answer element 			= this.collection[i];
			String alphabetIndex 	= Transform.indexToAlphabet(i);
			element.render(alphabetIndex);
		}
		
		// Object for - loop 		
//		for(Answer element : this.collection) {
//			element.render();
//		}
	}
	
	public void answer(String answerIndex) {
		
		String message = (this.isAnserValid(answerIndex)) ? "Верен отговор" : "Грешен отговор";
		Console.log(message);
	}
	
	
	public boolean isAnserValid(String answerIndex) {
		
		int index = Transform.alphabetToIndex(answerIndex);
		return this.collection[index].isValid;
	}
	
	
	
}
