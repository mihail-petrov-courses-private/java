package game;

import util.Console;

public class Game {
	
	public Question[] collection;
	
	public void start() {
		
		Console.log("Добре дошли в стани за смях");
		
		for(int i = 0; i < this.collection.length; i++) {
			
			Question element = this.collection[i]; 
			element.render();
						
			String answerAlphabet = Console.promtString("Изберете верния отговор");
			
			if(element.isAnserValid(answerAlphabet)) {
				Console.log("Верен отговор");
			}
			else {
				Console.log("Грешен отговор");
				break;
			}
		}
		
		Console.log("*** КРАЙ НА ИГРАТА *** ");
	}
}
