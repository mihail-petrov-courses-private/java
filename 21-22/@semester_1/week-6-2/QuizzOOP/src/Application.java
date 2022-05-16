import game.*;

//import game.Answer;
//import game.Question;

public class Application {
	
	public static void main(String[] args) {
		
		// create new object
		Question firstQuestion 		= new Question();
		firstQuestion.complexity 	= 1;
		firstQuestion.content 		= "Кога е създадена българската държава ?";
		firstQuestion.collection 	= new Answer[4];
		
		// create new Answer object
		Answer firstAnswer 			= new Answer();
		firstAnswer.content			= "681";
		firstAnswer.isValid			= true;
		
		Answer secondAnswer 		= new Answer();
		secondAnswer.content		= "812";
		secondAnswer.isValid		= false;
		
		Answer thirdAnswer 			= new Answer();
		thirdAnswer.content			= "1012";
		thirdAnswer.isValid			= false;
		
		Answer fourthAnswer 		= new Answer();
		fourthAnswer.content		= "1989";
		fourthAnswer.isValid		= false;
		
		firstQuestion.collection[0] = firstAnswer;
		firstQuestion.collection[1] = secondAnswer;
		firstQuestion.collection[2] = thirdAnswer;
		firstQuestion.collection[3] = fourthAnswer;
		
		
		// create new object
		Question secondQuestion 	= new Question();
		secondQuestion.complexity 	= 1;
		secondQuestion.content 		= "Колко зъба има възрастния индивид ?";
		secondQuestion.collection 	= new Answer[4];	
		
		// create new Answer object
		Answer firstAnswer2 		= new Answer();
		firstAnswer2.content		= "32";
		firstAnswer2.isValid		= true;
		
		Answer secondAnswer2 		= new Answer();
		secondAnswer2.content		= "18";
		secondAnswer2.isValid		= false;
		
		Answer thirdAnswer2 		= new Answer();
		thirdAnswer2.content		= "26";
		thirdAnswer2.isValid		= false;
		
		Answer fourthAnswer2 		= new Answer();
		fourthAnswer2.content		= "52";
		fourthAnswer2.isValid		= false;		
		
		secondQuestion.collection[0] = firstAnswer2;
		secondQuestion.collection[1] = secondAnswer2;
		secondQuestion.collection[2] = thirdAnswer2;
		secondQuestion.collection[3] = fourthAnswer2;
		
		// Game Object
		Game gameManager = new Game();
		gameManager.collection = new Question[2];
		gameManager.collection[0] = firstQuestion;
		gameManager.collection[1] = secondQuestion;
		// gameManager.collection = { firstQuestion, secondQuestion };
		
		gameManager.start();
		
		
		// ClassName.methodName();
		
		// objectName.methodName();
		// firstQuestion.render();
		//secondQuestion.render();
		
		// firstQuestion.answer("A");
	}
}
