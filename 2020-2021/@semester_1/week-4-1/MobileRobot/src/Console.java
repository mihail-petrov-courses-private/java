import java.util.Scanner;

public class Console {
	
	// Method overloading
	public static void log() { // log
		System.out.println("A");
	}
	
	public static void log(String message) { // log_String
		System.out.println(message);
	}
	
	public static void log(String m, int a) { // log_String_int
		System.out.println(m);
	}	
	
	public static void log(int message) {
		System.out.println(message);
	}	
	
	public static int promt(String message) {
		
		Scanner input 		= new Scanner(System.in);
		System.out.print(message);
		return input.nextInt();
	}	
}