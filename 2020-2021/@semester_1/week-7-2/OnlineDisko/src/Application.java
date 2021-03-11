public class Application {
	
	public static void main(String[] args) {
		
		// * createEvent
		// > name
		// > isAppropriateForUnderaged
		// EventOrganizer.createEvent("No COVID19 Party", false);
		EventOrganizer.createPartyForAll("No COVID19 Party"); 		// 1001
		EventOrganizer.createPartyForAll("New 2021 Party");			// 1002
		EventOrganizer.createPartyForAll("Black Party");			
		EventOrganizer.createPartyForAdoult("Disko Party 3021");	// 1004
		EventOrganizer.listAllEvents();
		
		// 
		EventOrganizer.removeEvent(1001);
		EventOrganizer.listAllEvents();
		
		EventOrganizer.updateEvent(1002, "Master Parttyyy LOOOOOOL", false);
		EventOrganizer.listAllEvents();
	}
}
