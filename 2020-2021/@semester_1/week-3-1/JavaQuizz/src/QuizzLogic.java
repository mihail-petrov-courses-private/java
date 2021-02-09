import java.util.Scanner;

public class QuizzLogic {
	
	public static String getDayOfWeek(int dayIndex) {
		
		int indexOffset = dayIndex - 1;
		
		String[] daysOfTheWeek = {
				"Monday",
				"Toesday",
				"Wednesday",
				"Thursday",
				"Friday"
		};		
		
		// $1
		// String day = daysOfTheWeek[indexOffset];
		// return day;
		
		// $2
		return daysOfTheWeek[indexOffset];
	}
	
	// Function
	public static int getNumberOfQuestionsForToday(int dayIndex, int numberOfVisitors) {
		
		boolean isRatingLow 	=  numberOfVisitors < 500;

		// (*) Multiplication
		boolean isRatingMedium 	=  ((numberOfVisitors > 500) && (numberOfVisitors < 1000));
		boolean isRatingHigh	= 	numberOfVisitors > 1000;

		// by using OR
		// (+) Addition
//		boolean isSpecialPriceAvailable = isRatingMedium ||
//										  isRatingHigh;

		// by using operator ==
//		boolean isSpecialPriceAvailable = (isRatingLow == false);
		
		// by using ! NOT
		boolean isSpecialPriceAvailable = !isRatingLow;
		
		
		boolean isMonday 		= (dayIndex == 0);
		boolean isFriday		= (dayIndex == 4);
		boolean isQuestionEasy 	= isRatingLow && isMonday;
		
		boolean isQuestionHard 	= isSpecialPriceAvailable;
		
		return isQuestionHard ? 
				(isFriday ? 
						12 
						: 
						15)  
				: 
				10;
	}
	
	public static void displayNumberOfQuestionsForToday(int dayIndex, int numberOfVisitors) {
		
		String dayOfWeek      = getDayOfWeek(dayIndex);
		int numberOfQuestions = getNumberOfQuestionsForToday(dayIndex, numberOfVisitors);
		String message 		  = "Number of Questions for " +   dayOfWeek + " is " + numberOfQuestions;
		
		System.out.print(message);
	}
	
	
	// Functionality
	// -> procedure
	// Вземете количеството на всички въпроси които 
	// ще бъдат зададени днес
	public static void displayNumberOfQuestionsForTodayByInput(int indexOfTheDay) {
		
		int indexOffset = indexOfTheDay - 1;
		
		String[] daysOfTheWeek = {
				"Monday",
				"Toesday",
				"Wednesday",
				"Thursday",
				"Friday"
		};
		
		String todayIdentificator = daysOfTheWeek[indexOffset]; 
		
		System.out.print("Enter number of questions for " + todayIdentificator + " ? : ");
		Scanner scanner = new Scanner(System.in);
		int numberOfQuestions = scanner.nextInt();
		System.out.print("We have " + numberOfQuestions + " questions" );
	}
		
}
