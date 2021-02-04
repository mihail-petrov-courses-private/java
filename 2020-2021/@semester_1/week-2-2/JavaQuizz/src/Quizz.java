import java.util.Scanner;

class Quizz {
	
	public static void main(String[] args) {

		/*
		 * Състезанието се провежда в няколко кръга, 
		 * като всеки кръг има различно количество въпроси. 
		 * Софтуера трябва да има възможност да съхранява данните за броя на кръговете, 
		 * в рамките на които се състезават играчите, както и за количеството въпроси, 
		 * които могат да бъдат зададени в рамките на всеки един от кръговете. 
		 * По проект, състезанието трябва да се проведе в 4 кръга, 
		 * като всеки един от тях, има съответно 10, въпроса, 7 въпроса, 5 въпроса и 
		 * един финален въпрос за голямата награда на шоуто. 
		 * */
		
		// Numeric data 
		// String data
		
		// Cammil Case
		int numberOfQuizzShowRounds = 4;
		
		int numberOfAssistentsUsedThrowTheRounds = numberOfQuizzShowRounds;
		
		
		// int number_of_question_in_round_one  = 10;
		// snake casing - _
		int numberOfQuestionInRoundOne  = 10;
		System.out.println(numberOfQuestionInRoundOne);
		
		// int NumberOfQuestionInRound2	= 7;
		// Pascall casing - upper first letter
		int numberOfQuestionInRound2	= 7;
		System.out.println(numberOfQuestionInRound2);
		
		// not available
		// int number-of-question-in-round-tree = 5;
		int numberOfQuestoionInRound3 	= 5;
		System.out.println(numberOfQuestoionInRound3);
		
		// special characters : _ / $
		int $numberOfQuestionInRoundFinal = 1;
		System.out.println(numberOfQuestionInRound2);
		
		// do not use reserved keywords
		// int break = 10;
		
		/* Всеки един от въпросите, носи със себе си някакъв точков актив, 
		 * който се добавя към максималният актив на играча.
		 */
		int playerScore = 0;
		System.out.println(playerScore);
		int grantPrize = 1_000_000_000;
		System.out.println(grantPrize); 
		
		/*
		 * Големите глави от екипа, са измислили страхотно название на 
		 * нашата игра. И тя е Quizz Show, 
		 * намерете начин как да съхранявате информацията в системата. 
		 */
		String mainTitle 				= "Quizz Show";
		char titleOfTheShowFirstChar 	= 'Q';
		String subTitle 				= "Hello world!";
		
		// String titleOfTheShow			= mainTitle + subTitle;
		String titleOfTheShow			= 	mainTitle 				+
											". "					+ 
											subTitle 				+ 
											" in " 					+ 
											numberOfQuizzShowRounds + 
											" rounds";
		
		System.out.println(titleOfTheShow);
		
		String likeANumber 	= "10";
		int realNumber 		= 10;
		// Concatenation result math
		// int numberCalculationResult = likeANumber + realNumber;
		// System.out.println(likeANumber + realNumber); // 1010
		
		/*
		 * Договорите ни задължават, да сме интересни и забавни, 
		 * през цялото време, но бюджета не ни позволява да наемем водещ с чувство за хумор.
		 * Трябва да имплементираме някакъв механизъм, чрез който да пазим информация за
		 * това как да включваме и изключваме табелката за аплодисменти, 
		 * така че да подчертаем забавния характер на предаването. 
		 */
		int isApplauseSignOnInNumber 		= 1; 	// 0 / 1
		char isApplacuseSignOnInChar 		= 'Y'; 	// Y / N
		String isApplacuseSignOnInString 	= "Y"; 	// Y / N
		boolean isApplauseSignOnBoolean		= true; // true / false
		boolean hasAccessToTheAdminPanel    = false;
		boolean hasRoleAdmin    			= false;
		boolean isAdmin						= false;
		boolean doesUserAcceptCreditCards	= true;
				
		/* Няма как да стане популярно предаването ако не вкараме някаква награда, 
		 * за тази цел сме поръчали чекове, които ще надпишем така че да не изчезнат, 
		 * докато не гледаме. Измислили сме специална сигнатура. 
		 * Всеки чек ще започна с буквичка която показва деня от седмицата в която 
		 * ще се проведе предаването както и последователност от цифри които да го 
		 * идентифицират.  */
		String checkId = "П" + 45678 + "87" ;
		System.out.println(checkId);
		
		/* Шоуто ще е активно всеки ден от седмицата, без Събота и Неделя. 
		 * В един момент ще е напълно, задължително да знаем, 
		 * колко души са се изредили през студиото, 
		 * ни за да можем да информираме рекламодателите. 
		 * Така че да започваме да съхранявамееее
		 */
		int allVisitorsOnMonday 	= 1000;
		int allVisitorsInThuesday 	= 2000;
		// ....
		int[] visitorsCollection 	= { allVisitorsOnMonday, 
										allVisitorsInThuesday, 
										3000, 
										500, 
										700 };
		
		System.out.println(visitorsCollection[0]);
		
		double netPrice = 1000_000.55578975; 
		
		/*
		  Ако искаш да станеш, зрител на нашата уникална шоу програма, 
		  добавете вашето име и ние ще ви се обадим 
		 */
		// Matrix 
		// Scanner reader = new Scanner(System.in); // създаване на нов обект
		// String myName  = reader.nextLine(); // извикване на метод с връщан резурлтат
		
		// System.out.println("Hello " + myName);
		
		// Comments
		// Single line
		/* Multry line */ 
		
		
		// 
		allVisitorsOnMonday = 8000;
		
		// 
		final int RATING_STELLAR 	= 5000;
		final int RATING_AVAREGE 	= 8000;
		final int RATING_GREAT 		= 10000;
		
		// Comparison operators :
		// > / >= / < / <= / ==
		// return boolean value
		boolean isRaitingOnMondayStellar = (allVisitorsOnMonday == RATING_STELLAR);
		isRaitingOnMondayStellar 		 = allVisitorsOnMonday <  RATING_GREAT;
		boolean isReatingGreater 		 = allVisitorsOnMonday < RATING_GREAT;
		boolean isRatingAvarageOrGreater = allVisitorsOnMonday >= RATING_AVAREGE;
		System.out.println(isRaitingOnMondayStellar);
		
		// Thurnery operator
		// ?: 
		// String ratingTitle = isReatingGreater ? "Reiting is great" : "Rating is not ok";
		 String ratingTitle = (allVisitorsOnMonday < RATING_GREAT) 
				 				? "Reiting is great" 
				 				: "Rating is not ok";
		 
		 System.out.println("What is my raiting on Monday : " + ratingTitle);
		 
		 
		 int stuffMemberCount = 20; 
		 
		 // Aritmetic operators
//		 int allVisitors = 	visitorsCollection[0] 	+ 
//				 			visitorsCollection[1]	+
//				 			visitorsCollection[2]	+
//				 			visitorsCollection[3]	+
//				 			visitorsCollection[4]	-
//				 			(stuffMemberCount * 5);	 			

		 int allVisitors = 	((visitorsCollection[0] - stuffMemberCount)  + 
		 					(visitorsCollection[1] - stuffMemberCount)   +
		 					(visitorsCollection[2] - stuffMemberCount)   +
		 				    (visitorsCollection[3] - stuffMemberCount)   +
		 				    (visitorsCollection[4] - stuffMemberCount));
		 
		 
		 final int HOST_COUNT = 1;
		 
		 // allVisitors = allVisitors - HOST_COUNT;
		 allVisitors  +=HOST_COUNT;
		 // +=
		 // -=
		 // *=
		 // /=
		 
		 System.out.println("ALL visitors : " + allVisitors);
		 	 
		 int aritmeticWithEvenNumbers = 10 / 5;
		 System.out.println(aritmeticWithEvenNumbers); // 2
		 
		 double doubleOperand1 = 10;
		 double doubleOperand2 = 6;
		 // double aritmeticWithStrangeNumbers = (10 / 6);
		 double aritmeticWithStrangeNumbers = (doubleOperand1 / doubleOperand2);
		 System.out.println(aritmeticWithStrangeNumbers ); // 1.666666666666667
		 
		 // %
		 System.out.println("Module devision : " + (11 % 2 ));
		 System.out.println("Module devision : " + (5.0 % 2.0 ));
		 
		 
		 boolean isEven = (10 % 2 == 0);
		 
		
	}
}