package util;

public class Transform {

	public static int alphabetToIndex(String alphabet) {
		
		//if(alphabet == "A") return 0;
		if(alphabet.equals("A")) return 0;
		//if(alphabet == "B") return 1;
		if(alphabet.equals("B")) return 1;
		//if(alphabet == "C") return 2;
		if(alphabet.equals("C")) return 2;
		//if(alphabet == "D") return 3;
		if(alphabet.equals("D")) return 3;
		//if(alphabet == "E") return 4;
		if(alphabet.equals("E")) return 4;
		
		return -1;
	}
	
	
	public static String indexToAlphabet(int index) {
		
		if(index > 5 || index < 0 ) {
			return "Z";
		}
		
		String[] alphabetCollection = {
				"A", "B", "C", "D", "E", "F"
		};
		
		return alphabetCollection[index];
	}
	
	
}
