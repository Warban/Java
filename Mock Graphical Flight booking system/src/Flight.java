import java.util.Date;
public abstract class Flight {

	public Movie MovieArray[] = new Movie[0]; 
	
	int FlightNumber; // Unique ID. 1000+/++
	String origin; // Globe location.
	String destination; // Globe location.
	Date TravelDate; // The date of departure.
	int ETD; // Estimated Time of Departure.
	int ETA; // Estimated Time of Arrival.
	double basePrice; // The Base price for each ticket.
	double concession; // 0.20% Takes 20% off the total price. 1.00% would cause the price to be $0 dollars.
	
	
	
	abstract double MakeBooking(Customer InputCustomer);
	
}
