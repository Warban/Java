
public class Customer {
	
	
	
	// Each customer is a travel set of a group of customers. There is issues with the design as it does not allow for growing of shrinking. Because of
	// this I have renamed them to Default* and plan to allow for booking to be modified off the default. This will be stored in Itinerary. 
	
	//public static boolean[] AllocateCustomerArray = new boolean[0];
	
	
	
	int id;	// Unique ID. 1+/++
	String CustomerCallName; // Last Name of Family.
	int DefaultchildSeats; // Seating defaults.
	int DefaultadultSeats; // Seating defaults.
	int numFlights; // The count of total flights 
	double Cost; // The Total Amount spent by the Customer.
	
	// Log File for all past bookings.
	public Itinerary[] BookingsLog = new Itinerary[0];
	
	public String[] FirstNames = new String[0];

	
	public Customer(){
		BookingsLog = new Itinerary[0];
	}
	 

	public static int FindFirstFreeID(Customer[] InputArray){
		int ActiveID = 1000;
		int SafeID;
		int[] IDCollection = new int[InputArray.length];
		for (int i = 0; i < InputArray.length ;i++){
			IDCollection[i] = InputArray[i].id;
			// Builds a collect of the ID's in the database.
		}
		
		for (int i = 0; i < IDCollection.length ;i++){
			if (ActiveID == IDCollection[i] ){
				// that number is taken here.
				ActiveID ++; // Increase number we are checking for. 1000, 1001, 1002 etc.
				i = 0; // Reset checking array. Start from the beginning again.
			}
			else{
				// that number is not taken here.
				// Keep checking the array.
			}
		}
		// Check has completed on the ActiveID.
		SafeID = ActiveID;
		return SafeID;
		
	}

	
}
