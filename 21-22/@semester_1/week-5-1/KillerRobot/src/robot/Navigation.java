package robot;

public class Navigation {

	public static String getDirection(int obstecleIndex) {
		
		if(obstecleIndex == 1) {
			return "Go sideway";
		}
		
		if(obstecleIndex == 2) {
			return "Jump";	
		}
		
		return "Forward";
	}
}
