
public class PaymentProcessor {
	
	public static final int LAGER_DISCOUNT 		= 1;
	public static final int NORMAL_DISCOUNT 	= 2;
	public static final int SPECIAL_DISCOUNT 	= 3;
	public static final int VIP_DISCOUNT 		= 4;
	
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
		return price - getDiscountBySerialNumber(serialNumber);		
	}
	
}
