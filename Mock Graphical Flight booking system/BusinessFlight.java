//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

public class BusinessFlight extends Flight{

	double Rate;
	
	
	
	BusinessFlight(){

		Movie MovieArray[] = new Movie[0]; 
		/*		
		int FlightNumber;
		String origin;
		String destination;
		Date TravelDate; 
		int ETD; // Estimated Time of Departure.
		int ETA; // Estimated Time of Arrival.
		double basePrice;
		double concession; */
	
		
	}
	
	
	public double MakeBooking(Customer InputCustomer) {
		// TODO Auto-generated method stub
		double TotalPrice = 0.0;
		double Midprice = 0.0;
		
		
		Midprice = (this.basePrice*this.Rate*InputCustomer.DefaultadultSeats);
		TotalPrice = TotalPrice + (Midprice-(Midprice*this.concession));
		return TotalPrice;
		
		
		
	}

	public static int FindFirstFreeID(BusinessFlight[] InputArray){
		int ActiveID = 1000;
		int SafeID;
		int[] IDCollection = new int[InputArray.length];
		for (int i = 0; i < InputArray.length ;i++){
			IDCollection[i] = InputArray[i].FlightNumber;
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
