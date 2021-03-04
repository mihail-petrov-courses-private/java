package game;

import util.Console;

public class Answer {
	
	public boolean isValid;
	public String content;

	public void render() {
		Console.log(this.content);
	}	
	
	public void render(int index) {
		Console.log("[" + index + "]" + this.content);
	}
	
	public void render(String index) {
		Console.log("[" + index + "]" + this.content);
	}	
	
}
