
public class SerialNumber {
	
	static final int COOL_COEFICIENT 				= 99;
	static final int NORMAL_COEFICIENT_LOWER_BOUND 	= 99999;
	static final int NORMAL_COEFICIENT_UPPER_BOUND 	= 999999;
	
	static final int EXTRA_MEAL_COEFICIENT 			= 3;
	
	public static boolean isNormal(int serialNumber) {
		
		return (serialNumber > NORMAL_COEFICIENT_LOWER_BOUND  )  &&  
		   (serialNumber < NORMAL_COEFICIENT_UPPER_BOUND);
	}
	
	public static boolean isLagger(int serialNumber) {
		return (serialNumber > NORMAL_COEFICIENT_UPPER_BOUND);
	}	

	public static boolean isEarlyAdopter(int serialNumber) {
		
		return 	   (
					serialNumber > COOL_COEFICIENT 	&& 
					!isNormal(serialNumber) 			&& 
					!isLagger(serialNumber)
				   );
	}	
	
	public static boolean isVIP(int serialNumber) {
		return (serialNumber % 2 == 0);
	}
	
	public static boolean isSuperVIP(int serialNumber) {
		
		return isVIP(serialNumber) &&
				isApplicableForExtraMeal(serialNumber);
	}
	
	public static boolean isApplicableForExtraMeal(int serialNumber) {
		
		// 14056 % 100 -> 56 / 10 -> 5   
		int nextToLastDigit = (serialNumber % 100) / 10;
		return nextToLastDigit > EXTRA_MEAL_COEFICIENT;
	}
	
	public static int discount(int serialNumber, int price) {
		
//		return (isSuperVIP(serialNumber)) 
//				? (price - 1)
//				: price;
		
		if(isSuperVIP(serialNumber)) {
			return price - 1;
		}
		else {
			return price;
		}
	}
	
}
