
public class EconomyFlight extends Flight {

	double groupDiscount;

	
	EconomyFlight(){
		
		Movie MovieArray[] = new Movie[0]; 
		// Builds EconomyFlight Here.
		
		/*		
		int FlightNumber;
		String origin;
		String destination;
		Date TravelDate; 
		int ETD; // Estimated Time of Departure.
		int ETA; // Estimated Time of Arrival.
		double basePrice;
		double concession; */
		
		
		
		this.groupDiscount = 0.20;
	}
	
	
	public double MakeBooking(Customer InputCustomer) {
		// TODO Auto-generated method stub
		double TotalPrice = 0.0;
		int TotalSeats = (InputCustomer.DefaultadultSeats + InputCustomer.DefaultchildSeats);
		int SeatCount = 0;

		
		//System.out.println(TotalSeats);
		//System.out.println(SeatCount);
		while (SeatCount < 4 && SeatCount < TotalSeats){
			TotalPrice = TotalPrice + this.basePrice;
			SeatCount ++;
		}
		while (SeatCount >= 4 && SeatCount < TotalSeats){
			TotalPrice = TotalPrice + (this.basePrice-(this.basePrice * this.groupDiscount));
			SeatCount ++;
		}
		return TotalPrice;
		
	}
	
	public static int FindFirstFreeID(EconomyFlight[] InputArray){
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
