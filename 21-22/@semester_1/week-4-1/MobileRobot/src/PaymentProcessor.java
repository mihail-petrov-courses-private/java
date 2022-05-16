
public class PaymentProcessor {
	
	public static final int LAGER_DISCOUNT 		= 1;
	public static final int NORMAL_DISCOUNT 	= 2;
	public static final int SPECIAL_DISCOUNT 	= 3;
	public static final int VIP_DISCOUNT 		= 4;
	
	
	/* Bad Practise
	 * 
	public static int discount(int serialNumber) {
		
		if(SerialNumberProcessor.isNormal(serialNumber)) {
			return 2;
		}
		else { 
			if(SerialNumberProcessor.isEarlyAdopter(serialNumber)) {
				return 3;
			}
			else {
				if(SerialNumberProcessor.isLagger(serialNumber)) {
					return 1; 
				}
				else {
					return 0;		
				}
			}
		}
	}
	*/
	
	/*
	public static int discount(int serialNumber) {
		
		if(SerialNumberProcessor.isNormal(serialNumber)) {
			return 2;
		}
		else if(SerialNumberProcessor.isEarlyAdopter(serialNumber)) {
			return 3;
		}
		else if(SerialNumberProcessor.isLagger(serialNumber)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	*/
	
	public static int getDiscountBySerialNumber(int serialNumber) {

		if(SerialNumberProcessor.isVIP(serialNumber)) {
			return VIP_DISCOUNT;
		}
		
		if(SerialNumberProcessor.isEarlyAdopter(serialNumber)) {
			return SPECIAL_DISCOUNT;
		}		
		
		if(SerialNumberProcessor.isNormal(serialNumber)) {
			return NORMAL_DISCOUNT;
		}
		
		if(SerialNumberProcessor.isLagger(serialNumber)) {
			return LAGER_DISCOUNT;
		}
		
		return 0;
	}
	
	public static int getPrice(int serialNumber, int price) {
		
		// 1. 
		// int priceDiscount = getDiscountBySerialNumber(serialNumber);
		// int finalOrderPrice = price - priceDiscount;
		
		// 2. 
		// int priceDiscount = getDiscountBySerialNumber(serialNumber);
		// return price - priceDiscount;
		
		// 3.
		return price - getDiscountBySerialNumber(serialNumber);		
	}

	
	/*
	public static int discount(int serialNumber) {
		
		if(SerialNumberProcessor.isNormal(serialNumber)) 		return 2;
		if(SerialNumberProcessor.isEarlyAdopter(serialNumber)) 	return 3;
		if(SerialNumberProcessor.isLagger(serialNumber)) 		return 1;
		
		return 0;
	}
	*/	
	

//	public static int discount(int serialNumber, int price) {
//		
////		return (isSuperVIP(serialNumber)) 
////				? (price - 1)
////				: price;
//		
//		if(SerialNumberProcessor.isSuperVIP(serialNumber)) {
//			return price - 1;
//		}
//		else {
//			return price;
//		}
//	}
	
	
}
