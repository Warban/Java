import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


//import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TravelGUI implements ListSelectionListener, ActionListener{
	
	public static final class Globals{
		// Back end DATAHOLD
		static public TravelAgent ATA = new TravelAgent();
		
		private static int ActiveSel = -1; // Object selected from the GUI list.
	
		private static int ActiveMovieObjID; // Container for current worked on object.
		private static int ActiveFlightObjID = -1; // Container for current worked on object within another object.
		private static int ActiveClientObjID = -1; // Container for current worked on object within another object.
		private static int ActiveLogObjID; // Container for current worked on object within another object.
		
		private static int ListTypeControl = -1; // List type control, -1 blank , 0 clients, 1 flights,
		private static DefaultListModel listobjects = new DefaultListModel();	// Container for the list
		static JList ActiveList; 
		
		private static DefaultListModel listMoviesModel = new DefaultListModel();	// Container for the list
		//private static JList MovieList;
		
		private static Customer ActiveCustomer  = new Customer();
		
		private static EconomyFlight ActiveEconomyFlight = new EconomyFlight();
		private static BusinessFlight ActiveBusinessFlight = new BusinessFlight();

		private static Movie ActiveMovie  = new Movie();
		
		//NOTE: ControlFRAME is a JFRAME PLUS ADDED FUNCTIONS.
		
		// Interface Control;	
		 
		static JPanel cards; 
		//CardLayout cl = (CardLayout)(cards.getLayout()) //cl.show(cards, ALTPANEL); Is the GUI switch.
				
		// Names for different Panels
		
		// STEPS:
		// CREATE NAME HERE. // ADD CARD LAYOUT. AND CREATE ASSOCATED METHOD. THEN LINK.
		final static String INFOPANEL = "Card for Program Infomation"; // Program start page
		final static String CREATEPANEL = "Card for Creating Objects"; // List of objects that can be created.
		
		final static String CREATECLIENTPANEL = "Card for Creating Client Objects"; // Page for entering Client details.
		final static String CREATEFLIGHTPANEL = "Card for Creating Flight Objects"; // Page for entering flight details.
		
		final static String EDITCLIENTPANEL = "Card for Editing Client Objects"; // Page for entering Client details.
		final static String EDITFLIGHTPANEL = "Card for Editing Flight Objects"; // Page for entering Client details.
		
		final static String CREATEMOVIEPANEL = "Card for Creating Movie Objects"; // Page for entering movie details.
		final static String EDITMOVIEPANEL = "Card for Editing Movie Objects"; // Page for entering Client details.
		final static String LISTMOVIEPANEL = "Card for Editing Movie Objects"; // Page for entering Client details.
		
		
		final static String LISTPANEL = "Card for Viewing Objects";
		final static String LISTLOGPANEL = "Card for Viewing internery Objects";
	    
		final static String BOOKPANEL = "Card for Booking Objects";
	    //
	}


	 
	public static class ATAControl { // METHODS THAT CONTROL THE ATA MODUEL DIRECTLY
			
		static public void DummyData(){
			
			
			// Two Customers
			Customer NewCustomerArray[] = new Customer[2];
			
			Customer NewCustomer = new Customer();
			Customer NewCustomer2 = new Customer();
			
			NewCustomerArray[0] = NewCustomer;
			NewCustomerArray[1] = NewCustomer2;
			
			NewCustomerArray[0].id = 1000;
			NewCustomerArray[0].CustomerCallName = "Bailey";
			NewCustomerArray[0].DefaultadultSeats = 2;
			NewCustomerArray[0].DefaultchildSeats = 0;
			
			NewCustomerArray[1].id = 1001;
			NewCustomerArray[1].CustomerCallName = "Jonson";
			NewCustomerArray[1].DefaultadultSeats = 2;
			NewCustomerArray[1].DefaultchildSeats = 2;
			
			Globals.ATA.CustomerArray = NewCustomerArray;
			
		
			
			
			// Two Flights
			BusinessFlight NewBusFlightArray[] = new BusinessFlight[2];
			EconomyFlight NewEcoFlightArray[] = new EconomyFlight[2];

			BusinessFlight NewBusFlight = new BusinessFlight();
			BusinessFlight NewBusFlight2 = new BusinessFlight();
			EconomyFlight NewEcoFlight = new EconomyFlight();
			EconomyFlight NewEcoFlight2 = new EconomyFlight();
			
			NewBusFlightArray[0] = NewBusFlight;
			NewBusFlightArray[1] = NewBusFlight2;
			
			NewEcoFlightArray[0] = NewEcoFlight;
			NewEcoFlightArray[1] = NewEcoFlight2;
			
			NewBusFlightArray[0].FlightNumber = 1000;
			NewEcoFlightArray[0].FlightNumber = 1000;
			
			NewBusFlightArray[0].TravelDate = new Date();
			NewEcoFlightArray[0].TravelDate = new Date();
			
			NewBusFlightArray[0].basePrice = 4000;
			NewEcoFlightArray[0].basePrice = 4000;
			
			NewBusFlightArray[0].origin = "Mudgee";
			NewEcoFlightArray[0].origin = "Mudgee";
			
			NewBusFlightArray[0].destination = "Sydney";
			NewEcoFlightArray[0].destination = "Sydney";
			
			NewBusFlightArray[0].ETD = 800;
			NewEcoFlightArray[0].ETD = 800;

			NewBusFlightArray[0].ETA = 1800;
			NewEcoFlightArray[0].ETA = 1800;
			
			NewBusFlightArray[0].concession = 0.20;
			NewEcoFlightArray[0].concession = 0.20;
			
			NewEcoFlightArray[0].groupDiscount = 0.20;
			NewBusFlightArray[0].Rate = 1.20;
			
			
			NewBusFlightArray[1].FlightNumber = 1001;
			NewEcoFlightArray[1].FlightNumber = 1001;
			
			NewBusFlightArray[1].TravelDate = new Date();
			NewEcoFlightArray[1].TravelDate = new Date();
			
			NewBusFlightArray[1].basePrice = 1200;
			NewEcoFlightArray[1].basePrice = 1200;
			
			NewBusFlightArray[1].origin = "Bathurst";
			NewEcoFlightArray[1].origin = "Bathurst";
			
			NewBusFlightArray[1].destination = "Dubbo";
			NewEcoFlightArray[1].destination = "Dubbo";
			
			NewBusFlightArray[1].ETD = 800;
			NewEcoFlightArray[1].ETD = 800;

			NewBusFlightArray[1].ETA = 1800;
			NewEcoFlightArray[1].ETA = 1800;
			
			NewBusFlightArray[1].concession = 0.40;
			NewEcoFlightArray[1].concession = 0.40;
			
			NewEcoFlightArray[1].groupDiscount = 0.30;
			NewBusFlightArray[1].Rate = 1.30;
			
			Globals.ATA.EcoFlightArray = NewEcoFlightArray;
			Globals.ATA.BusFlightArray = NewBusFlightArray;
			
			
			// Two Movies
			Movie NewMovieArray[] = new Movie[2];
			
			Movie NewMovie = new Movie();
			Movie NewMovie2 = new Movie();
			
			NewMovieArray[0] = NewMovie;
			NewMovieArray[1] = NewMovie2;
			
			NewMovieArray[0].Name = "The MOVIE";
			NewMovieArray[0].Duration = 45;
			
			NewMovieArray[1].Name = "The Sequal";
			NewMovieArray[1].Duration = 35;
			
			Globals.ATA.BusFlightArray[0].MovieArray = NewMovieArray;
			Globals.ATA.EcoFlightArray[0].MovieArray = NewMovieArray;
		}

		public static String CreateSimpleDate(Date InputDate){
			
			
			String ReturnDate;
			
			SimpleDateFormat simpleDateformat=new SimpleDateFormat("dd/MM/yyyy");
			ReturnDate = simpleDateformat.format(InputDate);

			return ReturnDate;
		}
		
		public static Date DateInputCheck(String InputDate){
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat Outputstyle = new SimpleDateFormat(pattern);

			Date activedate = null;
			try{
				activedate = Outputstyle.parse(InputDate);
				// How to make the output look correct. -V-
				//System.out.println(Outputstyle.format(activedate));
				
			    } 
			catch (ParseException e){
				//e.printStackTrace();
				System.out.println("!Error: Please use the format dd/mm/yyyy!");
				activedate = null;
				}
			return activedate;
			
			
		}
		

		

		
		public static DefaultListModel RefreshList (DefaultListModel listobjects){
			
			listobjects.removeAllElements();
			
			// Generate state of buttons.
			
			
			if (Globals.ListTypeControl == 0) { // CUSTOMER
				for (int i = 0 ;i < Globals.ATA.CustomerArray.length; i++){
					listobjects.addElement(
							"ID: " + Globals.ATA.CustomerArray[i].id + "   " +
							"Name: " + Globals.ATA.CustomerArray[i].CustomerCallName + "   " +
							"Adult Seats: " + Globals.ATA.CustomerArray[i].DefaultadultSeats + "   " +
							"Child Seats: " + Globals.ATA.CustomerArray[i].DefaultchildSeats + "   " +
							"");
				}
			}
			
			else if (Globals.ListTypeControl == 1) {
				for (int i = 0 ;i < Globals.ATA.EcoFlightArray.length; i++){
					String pattern = "dd/MM/yyyy";
					SimpleDateFormat Outputstyle = new SimpleDateFormat(pattern);
					listobjects.addElement(
							"Flight Number: " + Globals.ATA.EcoFlightArray[i].FlightNumber + "   " +
							"TravelDate: " + Outputstyle.format(Globals.ATA.EcoFlightArray[i].TravelDate)+ "   " +
							"Orig: " + Globals.ATA.EcoFlightArray[i].origin + "   " +
							"Dest: " + Globals.ATA.EcoFlightArray[i].destination + "   " + 
							"Depart Time: " + Globals.ATA.EcoFlightArray[i].ETD + "   " +
							"Arival Time: " + Globals.ATA.EcoFlightArray[i].ETA + "   " +
							"Base Price: $" + Globals.ATA.EcoFlightArray[i].basePrice + "   " +
							""
							);
				}
			}

			else if (Globals.ListTypeControl == 2) {
				for (int i = 0 ;i < Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID].MovieArray.length; i++){
					listobjects.addElement(
							"Movie Name: " + Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID].MovieArray[i].Name + "   " +
							"Movie Length: " + Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID].MovieArray[i].Duration
							);
				}
			}
			
			else if (Globals.ListTypeControl == 3) {
				for (int i = 0 ;i < Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog.length; i++){
					listobjects.addElement(
							"Cost: $" + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].flightcost + "   " +
							"Type: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].FlightType + "   " +
							"Adult: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].adultSeats + "   " +
							"Child: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].childSeats + "   " +
							"From: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].FlightFrom + "   " +
							"Dest: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].FlightTo + "   " +
							"Date: " + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i].DateBooked + "   "
							);
				}
			}
			
			return listobjects;
			
		}
		
		static public void DeleteObject (int ActiveObj, int ListTypeControl){
			
			
			System.out.println("Deleting..");
			
			if (ListTypeControl == 0){
				// ## REBUILD ARRAY... 
				Customer[] ActiveCustomerArray = new Customer[Globals.ATA.CustomerArray.length-1]; 
				
				// Everything before that object for deletion
				for (int ArrayPos = 0;ArrayPos < ActiveObj;ArrayPos++){
					//System.out.println("before" + ArrayPos);
					ActiveCustomerArray[ArrayPos] = Globals.ATA.CustomerArray[ArrayPos];
				}
				
				// Everything after that point...
				for (int ArrayPos = ActiveObj+1;ArrayPos < Globals.ATA.CustomerArray.length;ArrayPos++){
					//System.out.println("after" + ArrayPos);
					ActiveCustomerArray[ArrayPos-1] = Globals.ATA.CustomerArray[ArrayPos];

				}								
				
				Globals.ATA.CustomerArray = ActiveCustomerArray;
				return;
			}
			
			else if (ListTypeControl==1){
				
				// ## REBUILD ARRAY... 
				EconomyFlight[] ActiveEcoArray = new EconomyFlight[Globals.ATA.EcoFlightArray.length-1]; 
				BusinessFlight[] ActiveBusrArray = new BusinessFlight[Globals.ATA.BusFlightArray.length-1];
				
				// Everything before that object for deletion
				for (int ArrayPos = 0;ArrayPos < ActiveObj;ArrayPos++){
					//System.out.println("before" + ArrayPos);
					ActiveEcoArray[ArrayPos] = Globals.ATA.EcoFlightArray[ArrayPos];
					ActiveBusrArray[ArrayPos] = Globals.ATA.BusFlightArray[ArrayPos];
				}
				
				// Everything after that point...
				for (int ArrayPos = ActiveObj+1;ArrayPos < Globals.ATA.EcoFlightArray.length;ArrayPos++){
					//System.out.println("after" + ArrayPos);
					ActiveEcoArray[ArrayPos-1] = Globals.ATA.EcoFlightArray[ArrayPos];
					ActiveBusrArray[ArrayPos-1] = Globals.ATA.BusFlightArray[ArrayPos];

				}
				
				Globals.ATA.EcoFlightArray = ActiveEcoArray;
				Globals.ATA.BusFlightArray = ActiveBusrArray;
				return;
				
			}

			
		}
		
		
		static public void DeleteMovieObject (int FlightSel,int MovieSel , int ListTypeControl){
			System.out.println("Deleting Movie..");
				
		
			// ## REBUILD ARRAY... 
			Movie[] ActiveMovieArray = new Movie[Globals.ATA.EcoFlightArray[FlightSel].MovieArray.length-1]; 
			
			// Everything before that object for deletion
			for (int ArrayPos = 0;ArrayPos < MovieSel;ArrayPos++){
				System.out.println("before" + ArrayPos);
				ActiveMovieArray[ArrayPos] = Globals.ATA.EcoFlightArray[FlightSel].MovieArray[ArrayPos];
			}
			
			// Everything after that point...
			for (int ArrayPos = MovieSel+1;ArrayPos < Globals.ATA.EcoFlightArray[FlightSel].MovieArray.length;ArrayPos++){
				System.out.println("after" + ArrayPos);
				ActiveMovieArray[ArrayPos-1] = Globals.ATA.EcoFlightArray[FlightSel].MovieArray[ArrayPos];

			}
			
			Globals.ATA.EcoFlightArray[FlightSel].MovieArray = ActiveMovieArray;
			Globals.ATA.BusFlightArray[FlightSel].MovieArray = ActiveMovieArray;
			return;

		}

		
		static public void CreateCustomerObject (String ClName,int DfAdult,int DfChild){
			System.out.println("Creating Object");

			// Build Proximity Framework
			Customer ActiveArray[] = new Customer[Globals.ATA.CustomerArray.length+1];
			Customer ActiveCustomer = new Customer();
			
			// Discover and Set ID for new object.
			ActiveCustomer.id = Customer.FindFirstFreeID(Globals.ATA.CustomerArray); // Unique ID. 1000+/++
			
			// Array Length
			System.out.println("Array Size: " + Globals.ATA.CustomerArray.length);
			System.out.println("Array Size: " + ActiveArray.length);
			
			// Write all old records to new array.
			for (int i = 0;i < Globals.ATA.CustomerArray.length ;i++){
				ActiveArray[i] = Globals.ATA.CustomerArray[i];
			}
			
			ActiveCustomer.CustomerCallName = ClName;
			ActiveCustomer.DefaultadultSeats = DfAdult;
			ActiveCustomer.DefaultchildSeats = DfChild;
			
			ActiveCustomer.numFlights = 0; // The count of total flights 
			ActiveCustomer.Cost = 0.0; // The Total Amount spent by the Customer.
			
			System.out.println("commiting..");
			ActiveArray[Globals.ATA.CustomerArray.length] = ActiveCustomer;
			Globals.ATA.CustomerArray = ActiveArray;
			return;
			
			
		}



		

		public static void EditCustomerObject(Customer activeCoustomer, int inputObjID) {
			// TODO Auto-generated method stub
			
			System.out.println("activesel: " + Globals.ActiveSel);
			System.out.println("activeobj: " + inputObjID);

			
			
			Globals.ATA.CustomerArray[inputObjID] = activeCoustomer;
			Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
		}
		
		public static void EditFlightObject(int inputObjID, Date stringDate, String origin,
				String destination, int eTD, int eTA, double price,
				double concession, double bizRate, double goupDiscount) {
				
			// TODO Auto-generated method stub
			
			System.out.println("activeSel: " + inputObjID);


			Globals.ATA.BusFlightArray[inputObjID].basePrice = price;
			Globals.ATA.BusFlightArray[inputObjID].concession = concession;
			Globals.ATA.BusFlightArray[inputObjID].destination = destination;
			Globals.ATA.BusFlightArray[inputObjID].ETA = eTA;
			Globals.ATA.BusFlightArray[inputObjID].ETD = eTD;
			Globals.ATA.BusFlightArray[inputObjID].origin = origin;
			Globals.ATA.BusFlightArray[inputObjID].Rate = bizRate;
			Globals.ATA.BusFlightArray[inputObjID].TravelDate = stringDate;
			
			Globals.ATA.EcoFlightArray[inputObjID].basePrice = price;
			Globals.ATA.EcoFlightArray[inputObjID].concession = concession;
			Globals.ATA.EcoFlightArray[inputObjID].destination = destination;
			Globals.ATA.EcoFlightArray[inputObjID].ETA = eTA;
			Globals.ATA.EcoFlightArray[inputObjID].ETD = eTD;
			Globals.ATA.EcoFlightArray[inputObjID].origin = origin;
			Globals.ATA.EcoFlightArray[inputObjID].groupDiscount = goupDiscount;
			Globals.ATA.EcoFlightArray[inputObjID].TravelDate = stringDate;
			
			
			Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
		}
		
		

		public static void CreateFlightObject(Date stringDate, String origin,
				String destination, int eTD, int eTA, double price,
				double concession, double bizRate, double goupDiscount) {
			
			
			// Build Proximity Framework (EconomyFlight)
			EconomyFlight ActiveEcoArray[] = new EconomyFlight[Globals.ATA.EcoFlightArray.length+1];
			EconomyFlight ActiveEcoFlight = new EconomyFlight();
			
			// Build Proximity Framework (BusinessFlight)
			BusinessFlight ActiveBusArray[] = new BusinessFlight[Globals.ATA.BusFlightArray.length+1];
			BusinessFlight ActiveBusFlight = new BusinessFlight();
			

			// Discover and Set ID for new object. SETS FOR ACTIVE ID's
			ActiveEcoFlight.FlightNumber = EconomyFlight.FindFirstFreeID(Globals.ATA.EcoFlightArray); // Unique ID. 1000+/++
			ActiveBusFlight.FlightNumber = BusinessFlight.FindFirstFreeID(Globals.ATA.BusFlightArray); // Unique ID. 1000+/++
			
			// Write all old records to new array. (eco).
			for (int i = 0;i < Globals.ATA.EcoFlightArray.length ;i++){
				ActiveEcoArray[i] = Globals.ATA.EcoFlightArray[i];
			}
			
			// Write all old records to new array. (bus).
			for (int i = 0;i < Globals.ATA.BusFlightArray.length ;i++){
				ActiveBusArray[i] = Globals.ATA.BusFlightArray[i];
			}
			
			// Testing...	
			System.out.println("/add/Flight/"); // 
			System.out.println("Once created new ID will be: " + ActiveEcoFlight.FlightNumber); // reveal the Id 
			//System.out.println("Once created new ID will be: " + ActiveBusFlight.FlightNumber); // reveal the Id
			
			
			ActiveEcoFlight.TravelDate = stringDate;
			ActiveBusFlight.TravelDate = stringDate;
			
			ActiveEcoFlight.origin = origin;
			ActiveBusFlight.origin = origin;
			
			
			ActiveEcoFlight.destination = destination; // Destination
			ActiveBusFlight.destination = destination; // Destination
			
			
			ActiveEcoFlight.ETD = eTD; // Destination (eco)
			ActiveBusFlight.ETD = eTD; // Destination (Bus)
			
			ActiveEcoFlight.ETA = eTA; // Destination (eco)
			ActiveBusFlight.ETA = eTA; // Destination (Bus)
			
			ActiveEcoFlight.basePrice = price; // Base price of Flight.
			ActiveBusFlight.basePrice = price; // Base price of Flight.
			
			ActiveEcoFlight.concession = concession; // Base price of Flight.
			ActiveBusFlight.concession = concession; // Base price of Flight.
			
			
			ActiveEcoFlight.groupDiscount = goupDiscount ; // Destination
			
			ActiveBusFlight.Rate = bizRate ; // The Price for Busness.

			ActiveEcoArray[Globals.ATA.EcoFlightArray.length] = ActiveEcoFlight;
			ActiveBusArray[Globals.ATA.BusFlightArray.length] = ActiveBusFlight;


			Globals.ATA.EcoFlightArray = ActiveEcoArray;
			Globals.ATA.BusFlightArray = ActiveBusArray;
			
			Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
			
		}



		public static void CreateMovieObject(String name, int lenthInput,
				int inputObjID) {
			// TODO Auto-generated method stub
			
			
			Movie ActiveArray[] = new Movie[Globals.ATA.EcoFlightArray[inputObjID].MovieArray.length+1];
			Movie ActiveMovie = new Movie();
			//ActiveArray = ActiveTravelAgent.EcoFlightArray[pos].MovieArray;
			
			for (int i = 0;i < Globals.ATA.EcoFlightArray[inputObjID].MovieArray.length ;i++){
				ActiveArray[i] = Globals.ATA.EcoFlightArray[inputObjID].MovieArray[i];
			}
			
			
			
			ActiveMovie.Name = name;
			ActiveMovie.Duration = lenthInput;
			
			
			ActiveArray[Globals.ATA.EcoFlightArray[inputObjID].MovieArray.length] = ActiveMovie;
			// Overwriting static Array.
			Globals.ATA.BusFlightArray[inputObjID].MovieArray = ActiveArray;
			Globals.ATA.EcoFlightArray[inputObjID].MovieArray = ActiveArray;
			
			ATAControl.RefreshList(Globals.listobjects);
		}

		public static void EditMovieObject(Movie activeMovie,
				int activeObj, int activeSubObj) {

			Globals.ATA.BusFlightArray[activeObj].MovieArray[activeSubObj] = activeMovie;
			ATAControl.RefreshList(Globals.listobjects);
			
		}
		
		public static void BookFlightObject(
				String SelectedFlightType,
				int AdultSeats,
				int ChildSeats
				) {

			try{
				Globals.ActiveCustomer = Globals.ATA.CustomerArray[Globals.ActiveClientObjID];				
			}
			catch(ArrayIndexOutOfBoundsException e){
				Globals.ActiveCustomer = new Customer();
			}						
			try{
				Globals.ActiveBusinessFlight = Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID];	
				Globals.ActiveEconomyFlight = Globals.ATA.EcoFlightArray[Globals.ActiveFlightObjID];
			}
			catch(ArrayIndexOutOfBoundsException e){
				Globals.ActiveBusinessFlight = new BusinessFlight();
				Globals.ActiveEconomyFlight = new EconomyFlight();
				Globals.ActiveEconomyFlight.TravelDate = new Date();
				Globals.ActiveBusinessFlight.TravelDate = new Date();
			}
			
			
			Itinerary InputItinerary = new Itinerary();
			
			
			Double TotalPrice = 0.0;
			
			if (SelectedFlightType == "Economical"){
				// eco
				TotalPrice = Globals.ATA.EcoFlightArray[Globals.ActiveFlightObjID].MakeBooking(Globals.ATA.CustomerArray[Globals.ActiveClientObjID]);
				System.out.println("Total Price is: " + TotalPrice );
				
				
			}						
			else if (SelectedFlightType == "Business"){
				// bus
				TotalPrice = Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID].MakeBooking(Globals.ATA.CustomerArray[Globals.ActiveClientObjID]);
				System.out.println("Total Price is: " + TotalPrice );
			}
			
				
				
			
			
			
			
			System.out.println("Writing to object...");
			//InputItinerary.Customerid = SelectedCustomerID;
			InputItinerary.adultSeats = AdultSeats;
			InputItinerary.childSeats = ChildSeats;
			
			InputItinerary.DateBooked = Globals.ActiveBusinessFlight.TravelDate;
			InputItinerary.Flightid = Globals.ActiveBusinessFlight.FlightNumber;
			InputItinerary.FlightType = SelectedFlightType;

			InputItinerary.flightcost = TotalPrice;
			InputItinerary.FlightFrom = Globals.ActiveBusinessFlight.origin;
			InputItinerary.FlightTo = Globals.ActiveBusinessFlight.destination;
				
			
			Itinerary[] ActiveArray = new Itinerary[Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog.length+1];
			
			for (int i = 0;i < Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog.length ;i++){
				ActiveArray[i] = Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog[i];
			}
			
			// Bookings log updated...
			ActiveArray[Globals.ATA.CustomerArray[InputItinerary.Customerid].BookingsLog.length] = InputItinerary;
			Globals.ATA.CustomerArray[Globals.ActiveClientObjID].BookingsLog = ActiveArray;
			Globals.ATA.CustomerArray[Globals.ActiveClientObjID].Cost = TotalPrice + Globals.ATA.CustomerArray[Globals.ActiveClientObjID].Cost;
			Globals.ATA.CustomerArray[Globals.ActiveClientObjID].numFlights ++;
		    System.out.println("... Complete.");

			
		}
		
	}
		
	
    

	public static void main( String[] argv ) {
		
		// DummyData.
		TravelGUI.ATAControl.DummyData();
		
		// Bring to life the interface Frame.
		JFrame ControlFrame = new JFrame();		
		// Create Window Size.
		ControlFrame.setSize (800, 600);
		ControlFrame.setTitle("Flight Booking System");
		ControlFrame.setLocationRelativeTo(null); // Center the frame
		ControlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControlFrame.setVisible(true); 
		
		
	
		// FRAME.RULE (INSTANCE.METHOD());
	
		// Create Menu bar and then Interface Content pane.
		ControlFrame.setJMenuBar(PanelControl.createMenuBar());
		PanelControl.createJPanels(ControlFrame.getContentPane());

	}

	// Testing above.

	// CLass Methods.
	

	
	public static final class PanelControl { public static void createJPanels (Container pane){
		
		    //Create the "cards". as in calls the sub methods to generate what each of the main menu pages lead to.   
		    //Create the panel that contains the "cards".
			
		    //cards = new JPanel(new CardLayout());
			Globals.cards = new JPanel(new CardLayout());
		    
			
			
		    //pane.add(comboBoxPane, BorderLayout.PAGE_START);
		    pane.add(Globals.cards, BorderLayout.CENTER);
		    
		    PanelControl.RefreshJPanels(); // Refreshes all the pages.
		
		}



	// METHODS THAT CONTROL GUI OBJECTS and COLLECT DATA.
		

		public static void RefreshJPanels (){
	    
		Globals.cards.add(HelpObjectCard(), Globals.INFOPANEL);
		//Globals.cards.add(CreateObjectCard(), Globals.CREATEPANEL);
	
		Globals.cards.add(ListObjectCard(), Globals.LISTPANEL);
		//Globals.cards.add(ListMovieObjectCard(), Globals.LISTMOVIEPANEL);
		Globals.cards.add(BookObjectCard(), Globals.BOOKPANEL);
		
		Globals.cards.add(ClientClass.CreateClientObjectCard(), Globals.CREATECLIENTPANEL);
		Globals.cards.add(ClientClass.EditClientObjectCard(), Globals.EDITCLIENTPANEL);
		
		Globals.cards.add(FlightClass.CreateFlightObjectCard(), Globals.CREATEFLIGHTPANEL);
		Globals.cards.add(FlightClass.EditFlightObjectCard(), Globals.EDITFLIGHTPANEL);
		
		Globals.cards.add(MovieClass.CreateMovieObjectCard(), Globals.CREATEMOVIEPANEL);
		Globals.cards.add(MovieClass.EditMovieObjectCard(), Globals.EDITMOVIEPANEL);
	
		System.out.println ("INTERFACE HOOK RESET - PANELS UPDATED TO DISPLAY CORRECT INFOMATION");
		System.out.println ("");
		System.out.println ("Current State of Global verables:");
		System.out.println (":");
		System.out.println ("Globals.ActiveSel: " + Globals.ActiveSel);
		System.out.println ("ActiveMovieObjID : "+ Globals.ActiveMovieObjID);
		System.out.println ("ActiveFlightObjID:"+ Globals.ActiveFlightObjID);
		System.out.println ("ActiveClientObjID:"+Globals.ActiveClientObjID);
		System.out.println ("ActiveLogObjID   :"+Globals.ActiveLogObjID);
		System.out.println ("ListTypeControl  :"+Globals.ListTypeControl);
		System.out.println (":");
		
		
	
		
		
		
		
		//Globals.cards.add(ListInteneryObjectCard(), Globals.LISTLOGPANEL);
		
	}

		public static void Debuging (){
			System.out.println ("INTERFACE HOOK RESET - PANELS UPDATED TO DISPLAY CORRECT INFOMATION");
			System.out.println ("");
			System.out.println ("Current State of Global verables:");
			System.out.println (":");
			System.out.println ("Globals.ActiveSel: " + Globals.ActiveSel);
			System.out.println ("ActiveMovieObjID : "+ Globals.ActiveMovieObjID);
			System.out.println ("ActiveFlightObjID:"+ Globals.ActiveFlightObjID);
			System.out.println ("ActiveClientObjID:"+Globals.ActiveClientObjID);
			System.out.println ("ActiveLogObjID   :"+Globals.ActiveLogObjID);
			System.out.println ("ListTypeControl  :"+Globals.ListTypeControl);
			System.out.println (":");
		}


		public static JPanel HelpObjectCard (){
					// Basic card details ownership of the program.
					JPanel card = new JPanel();
					card.add( new JLabel("Click on the Funtions menu to begin.  Created By Christopher Bailey. 2011"));
					
					
				
		//			card.add(new JButton("Create Customer"));
		//			card.add(new JButton("List Customers"));		
		//			
		//			card.add(new JButton("Create Flight"));
		//			card.add(new JButton("List Flights"));
		//			
		//			card.add(new JButton("Make Booking"));
		//			card.add(new JButton("Quit"));
					return card;
				}



		public static JPanel ListObjectCard (){
			
			// Define interface.
			JPanel card = new JPanel();
		
			// Define the buttons.
			JButton jbtC = new JButton("Client");
			JButton jbtF = new JButton("Flight");
			
			final JButton CreateBt = new JButton("Create Object");
			CreateBt.setEnabled(false);			
			final JButton EditBt = new JButton("Edit Selection");
		    EditBt.setEnabled(false);
		    final JButton ListLogBt = new JButton("List Itinerary");
		    ListLogBt.setEnabled(false);
		    final JButton ListMovieBt = new JButton("List Movies");
		    ListMovieBt.setEnabled(false);
		    final JButton DeleteBt = new JButton("Delete Selection");
		    DeleteBt.setEnabled(false);
		    final JButton BookFlightBt = new JButton("Book Flight");
		    BookFlightBt.setEnabled(false);
		
		    Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);

			jbtC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Client +");	
					Globals.ListTypeControl = 0; // is CUSTOMER
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
					//CreateBt.setName("Create Client");
					CreateBt.setEnabled(true);
				}
			});
			
			
			jbtF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Flight");
					Globals.ListTypeControl = 1; // is FLIGHT
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
					//CreateBt.setName("Create Flight");
					CreateBt.setEnabled(true);
				}
			});
		
			
			CreateBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					//System.out.println("Event - Edit Object call. Using ID: " + Globals.ActiveSel + Globals.ListTypeControl );
					
					System.out.println("Checking....");

					if (Globals.ListTypeControl == 0){
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.CREATECLIENTPANEL);
						}
					
					else if (Globals.ListTypeControl == 1){
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.CREATEFLIGHTPANEL);
					}
					
					else if (Globals.ListTypeControl == 2){
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.CREATEMOVIEPANEL);	

					}
					
					else if (Globals.ListTypeControl == 3){
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.CREATEMOVIEPANEL);
													
					}
					

					
				}
			});
			
			EditBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					//System.out.println("Event - Edit Object call. Using ID: " + Globals.ActiveSel + Globals.ListTypeControl );
					
					System.out.println("Checking....");
					
					
					
					if (Globals.ListTypeControl == 0){ // Clients				
						
						Globals.cards.add(ClientClass.EditClientObjectCard(), Globals.EDITCLIENTPANEL);
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.EDITCLIENTPANEL);					
						
					}
					else if (Globals.ListTypeControl == 1){ // Flight
						Globals.cards.add(FlightClass.EditFlightObjectCard(), Globals.EDITFLIGHTPANEL);
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.EDITFLIGHTPANEL);								
					}
					
					else if (Globals.ListTypeControl == 2){ // Movies
						Globals.cards.add(MovieClass.EditMovieObjectCard(), Globals.EDITMOVIEPANEL);
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.EDITMOVIEPANEL);
					}
					
					else if (Globals.ListTypeControl == 3){ // Intenery

					}
					
					
				}
			});
			
		
			
			ListMovieBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					//System.out.println("Event - Edit Object call. Using ID: " + Globals.ActiveSel + Globals.ListTypeControl );
					
					System.out.println("Checking....");
					Globals.ActiveFlightObjID = Globals.ActiveSel;
		
					Globals.ListTypeControl = 2;
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
				
					
					

					CreateBt.setEnabled(true);		
					EditBt.setEnabled(true);					
					ListLogBt.setEnabled(false);
					ListMovieBt.setEnabled(false);
					DeleteBt.setEnabled(true);
					
				}
			});
			
			ListLogBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					System.out.println("Checking....");
					Globals.ActiveClientObjID = Globals.ActiveSel;
					
					Globals.ListTypeControl = 3;
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
					
					
					
					CreateBt.setEnabled(false);		
					EditBt.setEnabled(false);					
					ListLogBt.setEnabled(false);
					ListMovieBt.setEnabled(false);
					DeleteBt.setEnabled(false);
					
					
					
		
				}
			});
			
			DeleteBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					System.out.println("Event - Delete Object call. Using ID: " + Globals.ActiveSel);
		
					// Delete OBject
					
					
					
					
					if (Globals.ListTypeControl == 0){ // Clients		
						Globals.ActiveClientObjID = Globals.ActiveSel;
						TravelGUI.ATAControl.DeleteObject(Globals.ActiveClientObjID, Globals.ListTypeControl);
					}
					
					else if (Globals.ListTypeControl == 1){ // Flight
						Globals.ActiveFlightObjID = Globals.ActiveSel;
						TravelGUI.ATAControl.DeleteObject(Globals.ActiveFlightObjID, Globals.ListTypeControl);
					}
					
					else if (Globals.ListTypeControl == 2){ // Movie
						Globals.ActiveMovieObjID = Globals.ActiveSel;
						TravelGUI.ATAControl.DeleteMovieObject(Globals.ActiveFlightObjID,Globals.ActiveMovieObjID, Globals.ListTypeControl);

					}
					
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
				}
			});
		
			BookFlightBt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					
					Globals.cards.add(BookObjectCard(), Globals.BOOKPANEL);
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.BOOKPANEL);
					
					
		
				}
			});
			
			
		    //JList list; // To hold lists in the GUI     
			Globals.ActiveList = new JList(Globals.listobjects);
			Globals.ActiveList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Globals.ActiveList.setSelectedIndex(0);
		    // Lets change this to...
		    // list.addListSelectionListener(this);
		    // this..
			Globals.ActiveList.addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent e) {
									
					//System.out.println("Flag Action Press - ListvalueChanged");
					
					//System.out.println("ActiveSel: " + Globals.ActiveSel);
					
					Globals.ActiveSel = Globals.ActiveList.getSelectedIndex();

					System.out.println("ListSelectionEvent - Globals.ActiveSel: " +Globals.ActiveSel);
					
					
					if (Globals.ActiveSel == -1){
						
						EditBt.setEnabled(false);
						ListLogBt.setEnabled(false);
						ListMovieBt.setEnabled(false);
						DeleteBt.setEnabled(false);
						}
					else {
						

						if (Globals.ListTypeControl == 0){ // Customer
							CreateBt.setEnabled(true);
							EditBt.setEnabled(true);
							ListLogBt.setEnabled(true);
							ListMovieBt.setEnabled(false);
							DeleteBt.setEnabled(true);
							
							Globals.ActiveClientObjID = Globals.ActiveSel;
							//Globals.ActiveCustomer = Globals.ATA.CustomerArray[Globals.ActiveSel];
							
						}
						else if (Globals.ListTypeControl == 1){ // Flight
							CreateBt.setEnabled(true);
							EditBt.setEnabled(true);
							ListLogBt.setEnabled(false);
							ListMovieBt.setEnabled(true);
							DeleteBt.setEnabled(true);
							
							
							Globals.ActiveFlightObjID = Globals.ActiveSel;
							
						}
						else if (Globals.ListTypeControl == 2){ // Movie
							CreateBt.setEnabled(true);
							EditBt.setEnabled(true);
							ListLogBt.setEnabled(false);
							ListMovieBt.setEnabled(false);
							DeleteBt.setEnabled(true);
							
							Globals.ActiveMovieObjID = Globals.ActiveSel;
							
						}
						
						else if (Globals.ListTypeControl == 3){ // logs
							CreateBt.setEnabled(false);
							EditBt.setEnabled(false);
							ListLogBt.setEnabled(false);
							ListMovieBt.setEnabled(false);
							DeleteBt.setEnabled(false);
							
							Globals.ActiveLogObjID = Globals.ActiveSel;
							
						}
					}
					if (Globals.ActiveFlightObjID != -1 && Globals.ActiveClientObjID != -1){
						BookFlightBt.setEnabled(true);
					}
					

					
				}
			});
			// And thus the magic happens.
			Globals.ActiveList.setVisibleRowCount(25);
			Globals.ActiveList.setFixedCellWidth(780);
		    JScrollPane listScrollPane = new JScrollPane(Globals.ActiveList);
		    
		    
		    
		
		    
		    
		    // Set ordered layout of objects
			card.add(jbtC);
			card.add(jbtF);
		    
			card.add(listScrollPane, BorderLayout.CENTER);
		
			card.add(CreateBt);
			card.add(EditBt);
		    card.add(ListLogBt);
		    card.add(ListMovieBt);
		    card.add(DeleteBt);
		    card.add(BookFlightBt);
				
			
		
		    
			
		    //card.add(new JTextField("TextField", 20));
		    return card;
		}



	/*	public static JPanel CreateObjectCard (){
		
			JPanel card = new JPanel();
					
			JButton jbtC = new JButton("Client");
			JButton jbtF = new JButton("Flight");
			JButton jbtM = new JButton("Movie");
			
			
			card.add(jbtC);
			card.add(jbtF);
			//card.add(jbtM);
			
			jbtC.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Flight");
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.CREATECLIENTPANEL);
					
				}
			});
			
			jbtF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Flight");
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.CREATEFLIGHTPANEL);				
				}
			});
		
			//jbtM.addActionListener(new ActionListener() {
			//	public void actionPerformed(ActionEvent e) {
			//		System.out.println("Flag Action Press - Movie");
			//		
			//		CardLayout cl = (CardLayout)(Globals.cards.getLayout());
			//		cl.show(Globals.cards, Globals.CREATEMOVIEPANEL);
			//	}
			//});
			
			return card;
		}*/



		public static final class ClientClass {

		public static JPanel CreateClientObjectCard (){
		
			JPanel card = new JPanel();
			
			
			JPanel part0 = new JPanel(); // Top details.
			JPanel partA = new JPanel(); // Last Name. Client Name.
			JPanel partB = new JPanel(); // Default Adults
			JPanel partC = new JPanel(); // Default Children
			JPanel partZ = new JPanel(); // Submit buttons.
			
			
			part0.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partA.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partB.setPreferredSize(new Dimension(800,35));
			partC.setPreferredSize(new Dimension(800,35));
			partZ.setPreferredSize(new Dimension(800,35));
					
		
			part0.add( new JLabel("Enter the revelent infomation for creating a new Client"));
			
			JLabel jlbName = new JLabel("Client Last Name: (Required)");
			final JTextField jtxName = new JTextField(20);
			
			partA.add(jlbName);
			partA.add(jtxName);
		
			JLabel jlbAdult = new JLabel("Number of Default Adults: (Must be a Number) ");
			final JTextField jtxAdult = new JTextField("0",20);
			
			partB.add(jlbAdult);
			partB.add(jtxAdult);
			
			JLabel jlbChild = new JLabel("Number of Default Children: (Must be a Number)");
			final JTextField jtxChild = new JTextField("0",20);
			
			partC.add(jlbChild);
			partC.add(jtxChild);
			
			JButton jbtS = new JButton("Sumbit");
			JButton jbtC = new JButton("Clear");
			JButton jbtR = new JButton("Return");
			
			jbtS.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Sumbit");
					// Checks to see if the data is legal.
					
					boolean DataSafe = true;
					String Name = jtxName.getText();
					String Adult = jtxAdult.getText();
					String Child = jtxChild.getText();
		
					if (Name.equals("")){
						System.out.println("Name Error");
						DataSafe = false;
					}
				
		
					try{
						Integer.parseInt(Adult);
						Integer.parseInt(Child);
						
					}
					catch (NumberFormatException badstring){
						System.out.println("Number error");
						DataSafe = false;
					}
					
					if (DataSafe == true){
						int AdultInput = Integer.parseInt(Adult);
						int ChildInput = Integer.parseInt(Child);
						TravelGUI.ATAControl.CreateCustomerObject(Name, AdultInput, ChildInput);
						
						jtxName.setText("");
						jtxAdult.setText("0");
						jtxChild.setText("0");
						
						
						ATAControl.RefreshList(Globals.listobjects);
						
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.LISTPANEL);
					}
		
					System.out.println(DataSafe);
				}
			});
			
			jbtC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Clear");
					jtxName.setText("");
					jtxAdult.setText("0");
					jtxChild.setText("0");
				}
			});
		
			jbtR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Return");
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.LISTPANEL);
				}
			});
		
			partZ.add(jbtS);
			partZ.add(jbtC);
			partZ.add(jbtR);
			
			card.add(part0);
			card.add(partA);
			card.add(partB);
			card.add(partC);
			card.add(partZ);
			
			return card;
			
		}

		public static JPanel EditClientObjectCard (){
		
			
			System.out.println("EditClientObjectCard - flag");
			//System.out.println("Active Select: " + Globals.ActiveSel);
			
			
			try{
				Globals.ActiveCustomer = Globals.ATA.CustomerArray[Globals.ActiveClientObjID];				
			}
			catch(ArrayIndexOutOfBoundsException e){
				Globals.ActiveCustomer = new Customer();
			}
			
			
			// Globals.cards.add(EditClientObjectCard(), Globals.EDITCLIENTPANEL); use this to update a page when required.
			
		
			
			JPanel card = new JPanel();
			
			JPanel part0 = new JPanel(); // Top details.
			JPanel partA1 = new JPanel(); // ID: 
			JPanel partA2 = new JPanel(); // Last Name. Client Name.
			JPanel partB = new JPanel(); // Default Adults
			JPanel partC = new JPanel(); // Default Children
			JPanel partD = new JPanel(); // Current $ on account.
			JPanel partE = new JPanel(); // Number of FLights
			JPanel partZ = new JPanel(); // Submit buttons.
			
			
			part0.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partA1.setPreferredSize(new Dimension(800,35)); 
			partA2.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partB.setPreferredSize(new Dimension(800,35)); // Adult
			partC.setPreferredSize(new Dimension(800,35));
			partD.setPreferredSize(new Dimension(800,35));
			partE.setPreferredSize(new Dimension(800,35));
			partZ.setPreferredSize(new Dimension(800,35));
					
		
			part0.add( new JLabel("Change the revelent infomation for updating the Client"));
			
			JLabel jlbID = new JLabel("Client ID: (locked)");
			final JLabel jtxID = new JLabel(String.valueOf(Globals.ActiveCustomer.id));
			
			partA1.add(jlbID);
			partA1.add(jtxID);
			
			JLabel jlbName = new JLabel("Client Last Name: (Required)");
			final JTextField jtxName = new JTextField(Globals.ActiveCustomer.CustomerCallName,20);
			
			
			partA2.add(jlbName);
			partA2.add(jtxName);
		
			JLabel jlbAdult = new JLabel("Number of Default Adults: (Must be a Number) ");
			
			final JTextField jtxAdult = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultadultSeats),20);
			
			partB.add(jlbAdult);
			partB.add(jtxAdult);
			
			JLabel jlbChild = new JLabel("Number of Default Children: (Must be a Number)");
			final JTextField jtxChild = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultchildSeats),20);
			
			partC.add(jlbChild);
			partC.add(jtxChild);
			
			JLabel jlbCost = new JLabel("Amount Spent on account (Must be a Number) $");
			final JTextField jtxCost = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultchildSeats),20);
			
			partD.add(jlbCost);
			partD.add(jtxCost);
			
			JLabel jlbFlight = new JLabel("Number of Flights (Must be a Number)");
			final JTextField jtxFlight = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultchildSeats),20);
			
			partE.add(jlbFlight);
			partE.add(jtxFlight);
			
		
			
			
			//ActiveObject.numFlights
			
			
			
			//ActiveObject.Cost
			
			
			
			JButton jbtU = new JButton("Update");
			JButton jbtA = new JButton("Apply");
			JButton jbtR = new JButton("Return");
			
			jbtU.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					
					System.out.println("Flag Action Press - Sumbit");
					// Checks to see if the data is legal.
					
					boolean DataSafe = true;
					String Name = jtxName.getText();
					String Adult = jtxAdult.getText();
					String Child = jtxChild.getText();
					String Cost = jtxCost.getText();
					String Flights = jtxFlight.getText();
		
					if (Name.equals("")){
						System.out.println("Name Error");
						DataSafe = false;
					}
				
		
					try{
						int AdultInput = Integer.parseInt(Adult);
						int ChildInput = Integer.parseInt(Child);
						double CostInput = Double.parseDouble(Cost);
						double FLightInput = Double.parseDouble(Flights);
						
						//System.out.println (AdultInput+ChildInput);
					}
					catch (NumberFormatException badstring){
						System.out.println("Number error");
						DataSafe = false;
					}
					
					if (DataSafe = true){
						
						int AdultInput = Integer.parseInt(Adult);
						int ChildInput = Integer.parseInt(Child);
						double CostInput = Double.parseDouble(Cost);
						int FLightInput = Integer.parseInt(Flights);
						
						Globals.ActiveCustomer.CustomerCallName = Name;
						Globals.ActiveCustomer.numFlights = FLightInput;
						Globals.ActiveCustomer.Cost = CostInput;
						Globals.ActiveCustomer.DefaultchildSeats = ChildInput;
						Globals.ActiveCustomer.DefaultadultSeats = AdultInput;
						
						// update ATA here.
						
						System.out.println("ActiveObj: " + Globals.ActiveSel);
						TravelGUI.ATAControl.EditCustomerObject(Globals.ActiveCustomer, Globals.ActiveClientObjID);
						
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.LISTPANEL);
						
						
						
					}
					// System.out.println(DataSafe);
					
				}
			});
			
			jbtA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					System.out.println("Flag Action Press - Sumbit");
					// Checks to see if the data is legal.
					
					boolean DataSafe = true;
					String Name = jtxName.getText();
					String Adult = jtxAdult.getText();
					String Child = jtxChild.getText();
					String Cost = jtxCost.getText();
					String Flights = jtxFlight.getText();
		
					if (Name.equals("")){
						System.out.println("Name Error");
						DataSafe = false;
					}
				
		
					try{
						int AdultInput = Integer.parseInt(Adult);
						int ChildInput = Integer.parseInt(Child);
						double CostInput = Double.parseDouble(Cost);
						double FLightInput = Double.parseDouble(Flights);
						
						//System.out.println (AdultInput+ChildInput);
					}
					catch (NumberFormatException badstring){
						System.out.println("Number error");
						DataSafe = false;
					}
					
					if (DataSafe = true){
						
						int AdultInput = Integer.parseInt(Adult);
						int ChildInput = Integer.parseInt(Child);
						double CostInput = Double.parseDouble(Cost);
						int FLightInput = Integer.parseInt(Flights);
						
						Globals.ActiveCustomer.CustomerCallName = Name;
						Globals.ActiveCustomer.numFlights = FLightInput;
						Globals.ActiveCustomer.Cost = CostInput;
						Globals.ActiveCustomer.DefaultchildSeats = ChildInput;
						Globals.ActiveCustomer.DefaultadultSeats = AdultInput;
						
						// update ATA here.
						TravelGUI.ATAControl.EditCustomerObject(Globals.ActiveCustomer, Globals.ActiveClientObjID);
						
						
						
						
						
					}
					// System.out.println(DataSafe);
					
				}
			});
		
			jbtR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - Return");
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.LISTPANEL);
				}
			});
		
			partZ.add(jbtU);
			partZ.add(jbtA);
			partZ.add(jbtR);
			
			card.add(part0);
			card.add(partA1);
			card.add(partA2);
			card.add(partB);
			card.add(partC);
			card.add(partD);
			card.add(partE);
			card.add(partZ);
			
			return card;
			
		}
			
		}
		
		public static final class FlightClass {

			public static JPanel CreateFlightObjectCard (){
				
				System.out.println("CreateFlightObjectCard - flag");
				JPanel card = new JPanel();
				
				JPanel part0 = new JPanel(); // Details about page. 
				JPanel partA = new JPanel(); // Date.
				JPanel partB = new JPanel(); // origin.
				JPanel partC = new JPanel(); // destination.
				JPanel partD = new JPanel(); // ETD
				JPanel partE = new JPanel(); // ETA
				JPanel partF1 = new JPanel(); // Base Price
				JPanel partF = new JPanel(); // concession
				JPanel partG = new JPanel(); // groupDiscount / Eco discount.
				JPanel partH = new JPanel(); // Rate / BizRate
				JPanel partZ = new JPanel(); // Submit buttons.
				
				part0.setPreferredSize(new Dimension(800,35));
				partA.setPreferredSize(new Dimension(800,35));
				partB.setPreferredSize(new Dimension(800,35));
				partC.setPreferredSize(new Dimension(800,35));
				partD.setPreferredSize(new Dimension(800,35));
				partE.setPreferredSize(new Dimension(800,35));
				partF1.setPreferredSize(new Dimension(800,35));
				partF.setPreferredSize(new Dimension(800,35));
				partG.setPreferredSize(new Dimension(800,35));
				partH.setPreferredSize(new Dimension(800,35));
				partZ.setPreferredSize(new Dimension(800,35));
				
				
				part0.add( new JLabel("Enter the revelent infomation for creating a new Flight Object"));
				
				final JLabel jlbDate = new JLabel("Date: (Required)");
				final JTextField jtxDate = new JTextField("dd/MM/yyyy",20);
				
				partA.add(jlbDate);
				partA.add(jtxDate);	
				
				final JLabel jlbOrigin = new JLabel("Origin: (Required)");
				final JTextField jtxOrigin = new JTextField(20);
				
				partB.add(jlbOrigin);
				partB.add(jtxOrigin);
				
				final JLabel jlbDestination = new JLabel("Destination: (Required)");
				final JTextField jtxDestination = new JTextField(20);
				
				partC.add(jlbDestination);
				partC.add(jtxDestination);
				
				final JLabel jlbETD = new JLabel("ETD: (Required)");
				final JTextField jtxETD = new JTextField("0000",20);
				
				partD.add(jlbETD);
				partD.add(jtxETD);
				
				final JLabel jlbETA = new JLabel("ETA: (Required)");
				final JTextField jtxETA = new JTextField("0000",20);
				
				partE.add(jlbETA);
				partE.add(jtxETA);
				
				final JLabel jlbPrice = new JLabel("Base Price: (Number)$");
				final JTextField jtxPrice = new JTextField("2500",20);
				
				partF1.add(jlbPrice);
				partF1.add(jtxPrice);
				
				final JLabel jlbconcession = new JLabel("Concession Discount Rate: (Number)");
				final JTextField jtxconcession = new JTextField("0.20",20);
				
				partF.add(jlbconcession);
				partF.add(jtxconcession);
				
				final JLabel jlbBizRate = new JLabel("Business Rate Increase: (Number)");
				final JTextField jtxBizRate = new JTextField("1.25",20);
				
				partG.add(jlbBizRate);
				partG.add(jtxBizRate);
				
				final JLabel jlbgroupDiscount = new JLabel("Group Discount Rate: (Number)");
				final JTextField jtxgroupDiscount = new JTextField("0.10",20);
				
				partH.add(jlbgroupDiscount);
				partH.add(jtxgroupDiscount);
				
				
				JButton jbtS = new JButton("Sumbit");
				JButton jbtC = new JButton("Clear");
				JButton jbtR = new JButton("Return");
				
				
				
				jbtS.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						boolean DataSafe = true;
						Date CurrentDate = null;
						
						
						// Collect Strings.
						String StringDate = jtxDate.getText();	
						String Origin = jtxOrigin.getText();
						String Destination = jtxDestination.getText();		
						String ETD = jtxETD.getText();
						String ETA = jtxETA.getText();
						String Price = jtxPrice.getText();
						String Concession = jtxconcession.getText();
						String BizRate = jtxBizRate.getText();
						String GoupDiscount = jtxgroupDiscount.getText();
						
						
						// Date Check.
						System.out.println(StringDate);
						CurrentDate = ATAControl.DateInputCheck(StringDate);
						
						if (CurrentDate == null){
							System.out.println("Date error");
							DataSafe = false;
						}
						
						if (Origin.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
						if (Destination.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
							
						
						try{
							Integer.parseInt(ETD);
							Integer.parseInt(ETA);
							Double.parseDouble(Price);
							Double.parseDouble(Concession);
							Double.parseDouble(BizRate);
							Double.parseDouble(GoupDiscount);
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						int InputETD = Integer.parseInt(ETD);
						int InputETA = Integer.parseInt(ETA);
						double inputPrice = Double.parseDouble(Price);
						double inputConcession = Double.parseDouble(Concession);
						double inputBizRate = Double.parseDouble(BizRate);
						double inputGoupDiscount = Double.parseDouble(GoupDiscount);
						
			
						//String Name = jlbData.getText();
						//String Adult = jtxAdult.getText();
						//String Child = jtxChild.getText();					
			
						if (DataSafe == true){
							System.out.println(CurrentDate);
			
							TravelGUI.ATAControl.CreateFlightObject(
									CurrentDate, 
									Origin, 
									Destination,
									InputETD,
									InputETA,
									inputPrice,
									inputConcession,
									inputBizRate,
									inputGoupDiscount
									);
							
							
							//jlbData.setText("");
							//jtxAdult.setText("0");
							//jtxChild.setText("0");
							
							CardLayout cl = (CardLayout)(Globals.cards.getLayout());
							cl.show(Globals.cards, Globals.LISTPANEL);
						}
						System.out.println(DataSafe);
						
			
						
					}
				});
				
				jbtC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Clear");			
						
						jtxDate.setText("dd/MM/yyyy");
						
						jtxOrigin.setText("");
						jtxDestination.setText("");
						
						jtxETD.setText("0000");
						jtxETA.setText("0000");
			
						jtxPrice.setText("2500");
						jtxconcession.setText("0.20");
						
						jtxBizRate.setText("1.25");
						jtxgroupDiscount.setText("0.10");
			
					}
				});
				
				jbtR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Return");
						
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.LISTPANEL);
					}
				});
				
				
				partZ.add(jbtS);
				partZ.add(jbtC);
				partZ.add(jbtR);
				
				card.add(part0);
				card.add(partA);
				card.add(partB);
				card.add(partC);
				card.add(partD);
				card.add(partE);
				card.add(partF1);
				card.add(partF);
				card.add(partG);
				card.add(partH);
				card.add(partZ);
				
			
				
				
				
				
				
				return card;
				
				
				
				
				
			}

			public static JPanel EditFlightObjectCard (){
				
				System.out.println("EditFlightObjectCard - flag");
				JPanel card = new JPanel();
				
				
				try{
					Globals.ActiveBusinessFlight = Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID];	
					Globals.ActiveEconomyFlight = Globals.ATA.EcoFlightArray[Globals.ActiveFlightObjID];
				}
				catch(ArrayIndexOutOfBoundsException e){
					Globals.ActiveBusinessFlight = new BusinessFlight();
					Globals.ActiveEconomyFlight = new EconomyFlight();
					Globals.ActiveEconomyFlight.TravelDate = new Date();
					Globals.ActiveBusinessFlight.TravelDate = new Date();
				}
				
				
				JPanel part0 = new JPanel(); // Details about page. 
				JPanel partA1 = new JPanel(); // ID Number.
				JPanel partA2 = new JPanel(); // Date.
				JPanel partB = new JPanel(); // origin.
				JPanel partC = new JPanel(); // destination.
				JPanel partD = new JPanel(); // ETD
				JPanel partE = new JPanel(); // ETA
				JPanel partF1 = new JPanel(); // Base Price
				JPanel partF = new JPanel(); // concession
				JPanel partG = new JPanel(); // groupDiscount / Eco discount.
				JPanel partH = new JPanel(); // Rate / BizRate
				JPanel partZ = new JPanel(); // Submit buttons.
				
				part0.setPreferredSize(new Dimension(800,35));
				partA1.setPreferredSize(new Dimension(800,35));
				partA2.setPreferredSize(new Dimension(800,35));
				partB.setPreferredSize(new Dimension(800,35));
				partC.setPreferredSize(new Dimension(800,35));
				partD.setPreferredSize(new Dimension(800,35));
				partE.setPreferredSize(new Dimension(800,35));
				partF1.setPreferredSize(new Dimension(800,35));
				partF.setPreferredSize(new Dimension(800,35));
				partG.setPreferredSize(new Dimension(800,35));
				partH.setPreferredSize(new Dimension(800,35));
				partZ.setPreferredSize(new Dimension(800,35));
				
				
				part0.add( new JLabel("Enter the revelent infomation for creating a new Flight Object"));
			
				final JLabel jlbID = new JLabel("Date: (Required)");
				final JLabel jtxID = new JLabel(String.valueOf(Globals.ActiveEconomyFlight.FlightNumber));
				
				partA1.add(jlbID);
				partA1.add(jtxID);	
				
				final JLabel jlbDate = new JLabel("Date: (Required)");
				final JTextField jtxDate = new JTextField(ATAControl.CreateSimpleDate(Globals.ActiveEconomyFlight.TravelDate),32);
			
				partA2.add(jlbDate);
				partA2.add(jtxDate);	
				
				final JLabel jlbOrigin = new JLabel("Origin: (Required)");
				final JTextField jtxOrigin = new JTextField(Globals.ActiveEconomyFlight.origin,20);
				
				partB.add(jlbOrigin);
				partB.add(jtxOrigin);
				
				final JLabel jlbDestination = new JLabel("Destination: (Required)");
				final JTextField jtxDestination = new JTextField(Globals.ActiveEconomyFlight.destination,20);
				
				partC.add(jlbDestination);
				partC.add(jtxDestination);
				
				final JLabel jlbETD = new JLabel("ETD: (Required)");
				final JTextField jtxETD = new JTextField(String.valueOf(Globals.ActiveEconomyFlight.ETD),20);
				
				partD.add(jlbETD);
				partD.add(jtxETD);
				
				final JLabel jlbETA = new JLabel("ETA: (Required)");
				final JTextField jtxETA = new JTextField(String.valueOf(Globals.ActiveEconomyFlight.ETA),20);
				
				partE.add(jlbETA);
				partE.add(jtxETA);
				
				final JLabel jlbPrice = new JLabel("Base Price: (Number)$");
				final JTextField jtxPrice = new JTextField(String.valueOf(Globals.ActiveEconomyFlight.basePrice),20);
				
				partF1.add(jlbPrice);
				partF1.add(jtxPrice);
				
				final JLabel jlbconcession = new JLabel("Concession Discount Rate: (Number)");
				final JTextField jtxconcession = new JTextField(String.valueOf(Globals.ActiveEconomyFlight.concession),20);
				
				partF.add(jlbconcession);
				partF.add(jtxconcession);
				
				final JLabel jlbBizRate = new JLabel("Business Rate Increase: (Number)");
				final JTextField jtxBizRate = new JTextField(String.valueOf(Globals.ActiveBusinessFlight.Rate),20);
				
				partG.add(jlbBizRate);
				partG.add(jtxBizRate);
				
				final JLabel jlbgroupDiscount = new JLabel("Group Discount Rate: (Number)");
				final JTextField jtxgroupDiscount = new JTextField(String.valueOf(Globals.ActiveEconomyFlight.groupDiscount),20);
				
				partH.add(jlbgroupDiscount);
				partH.add(jtxgroupDiscount);
				
				
				JButton jbtU = new JButton("Update");
				JButton jbtA = new JButton("Apply");
				JButton jbtR = new JButton("Return");
				
				
				partZ.add(jbtU);
				partZ.add(jbtA);
				partZ.add(jbtR);
				
				jbtU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						boolean DataSafe = true;
						Date CurrentDate = null;
						
						
						// Collect Strings.
						String StringDate = jtxDate.getText();	
						String Origin = jtxOrigin.getText();
						String Destination = jtxDestination.getText();		
						String ETD = jtxETD.getText();
						String ETA = jtxETA.getText();
						String Price = jtxPrice.getText();
						String Concession = jtxconcession.getText();
						String BizRate = jtxBizRate.getText();
						String GoupDiscount = jtxgroupDiscount.getText();
						
						
						// Date Check.
						System.out.println(StringDate);
						CurrentDate = ATAControl.DateInputCheck(StringDate);
						
						if (CurrentDate == null){
							System.out.println("Date error");
							DataSafe = false;
						}
						
						if (Origin.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
						if (Destination.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
							
						
						try{
							Integer.parseInt(ETD);
							Integer.parseInt(ETA);
							Double.parseDouble(Price);
							Double.parseDouble(Concession);
							Double.parseDouble(BizRate);
							Double.parseDouble(GoupDiscount);
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						int InputETD = Integer.parseInt(ETD);
						int InputETA = Integer.parseInt(ETA);
						double inputPrice = Double.parseDouble(Price);
						double inputConcession = Double.parseDouble(Concession);
						double inputBizRate = Double.parseDouble(BizRate);
						double inputGoupDiscount = Double.parseDouble(GoupDiscount);
						
			
						//String Name = jlbData.getText();
						//String Adult = jtxAdult.getText();
						//String Child = jtxChild.getText();					
			
						if (DataSafe == true){
							//System.out.println(CurrentDate);
			
							TravelGUI.ATAControl.EditFlightObject(
									Globals.ActiveFlightObjID, 
									CurrentDate, 
									Origin, 
									Destination, 
									InputETD, 
									InputETA, 
									inputPrice, 
									inputConcession, 
									inputBizRate, 
									inputGoupDiscount);
							
							
							//jlbData.setText("");
							//jtxAdult.setText("0");
							//jtxChild.setText("0");
							
							CardLayout cl = (CardLayout)(Globals.cards.getLayout());
							cl.show(Globals.cards, Globals.LISTPANEL);
						}
						System.out.println(DataSafe);
						
			
						
					}
				});
				
				jbtA.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						boolean DataSafe = true;
						Date CurrentDate = null;
						
						
						// Collect Strings.
						String StringDate = jtxDate.getText();	
						String Origin = jtxOrigin.getText();
						String Destination = jtxDestination.getText();		
						String ETD = jtxETD.getText();
						String ETA = jtxETA.getText();
						String Price = jtxPrice.getText();
						String Concession = jtxconcession.getText();
						String BizRate = jtxBizRate.getText();
						String GoupDiscount = jtxgroupDiscount.getText();
						
						
						// Date Check.
						System.out.println(StringDate);
						CurrentDate = ATAControl.DateInputCheck(StringDate);
						
						if (CurrentDate == null){
							System.out.println("Date error");
							DataSafe = false;
						}
						
						if (Origin.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
						if (Destination.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
							
						
						try{
							Integer.parseInt(ETD);
							Integer.parseInt(ETA);
							Double.parseDouble(Price);
							Double.parseDouble(Concession);
							Double.parseDouble(BizRate);
							Double.parseDouble(GoupDiscount);
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						int InputETD = Integer.parseInt(ETD);
						int InputETA = Integer.parseInt(ETA);
						double inputPrice = Double.parseDouble(Price);
						double inputConcession = Double.parseDouble(Concession);
						double inputBizRate = Double.parseDouble(BizRate);
						double inputGoupDiscount = Double.parseDouble(GoupDiscount);
						
			
						//String Name = jlbData.getText();
						//String Adult = jtxAdult.getText();
						//String Child = jtxChild.getText();					
			
						if (DataSafe == true){
							System.out.println(CurrentDate);
			
							TravelGUI.ATAControl.EditFlightObject(
									Globals.ActiveFlightObjID, 
									CurrentDate, 
									Origin, 
									Destination, 
									InputETD, 
									InputETA, 
									inputPrice, 
									inputConcession, 
									inputBizRate, 
									inputGoupDiscount);
							
							
							//jlbData.setText("");
							//jtxAdult.setText("0");
							//jtxChild.setText("0");
							
							
						}
						System.out.println(DataSafe);
						
			
						
					}
				});
				
				jbtR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Return");
						
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.LISTPANEL);
					}
				});
				
				card.add(part0);
				card.add(partA1);
				card.add(partA2);
				card.add(partB);
				card.add(partC);
				card.add(partD);
				card.add(partE);
				card.add(partF1);
				card.add(partF);
				card.add(partG);
				card.add(partH);
				card.add(partZ);
				
				return card;
				
			}
			
			
			
			
		}

		public static final class MovieClass {

			public static JPanel CreateMovieObjectCard (){
				
				System.out.println("CreateMovieObjectCard - flag");
				JPanel card = new JPanel();
				
				
				JPanel part0 = new JPanel(); // Top details.
				JPanel partA = new JPanel(); // Movie Name.
				JPanel partB = new JPanel(); // Length,
				JPanel partZ = new JPanel(); // Submit buttons.
				
				
				part0.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
				partA.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
				partB.setPreferredSize(new Dimension(800,35));
				partZ.setPreferredSize(new Dimension(800,35));
						
				
				part0.add( new JLabel("Enter the revelent infomation for creating the Movie"));
				
				JLabel jlbName = new JLabel("Movie Name: (Required)");
				final JTextField jtxName = new JTextField(20);
				
				partA.add(jlbName);
				partA.add(jtxName);
				
				JLabel jlbLength = new JLabel("Length: (Must be a Number) ");
				final JTextField jtxLength = new JTextField("30",20);
				
				partB.add(jlbLength);
				partB.add(jtxLength);
				
				JButton jbtS = new JButton("Sumbit");
				JButton jbtC = new JButton("Clear");
				JButton jbtR = new JButton("Return");
				
				
				jbtS.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						
						boolean DataSafe = true;
						String Name = jtxName.getText();
						String Length = jtxLength.getText();
						
			
						if (Name.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
					
			
						try{
							Integer.parseInt(Length);
							//Integer.parseInt(Child);
							
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						if (DataSafe == true){
							int LenthInput = Integer.parseInt(Length);
							
							TravelGUI.ATAControl.CreateMovieObject(Name, LenthInput, Globals.ActiveFlightObjID);
							
							jtxName.setText("");
							jtxLength.setText("0");
							//jtxChild.setText("0");
							
							
							
							CardLayout cl = (CardLayout)(Globals.cards.getLayout());
							cl.show(Globals.cards, Globals.LISTPANEL);
						}
			
						System.out.println(DataSafe);
					}
				});
				
				partZ.add(jbtS);
				partZ.add(jbtC);
				partZ.add(jbtR);
				
				card.add(part0);
				card.add(partA);
				card.add(partB);
				//card.add(partC);
				card.add(partZ);
				
				
				return card;
				
			}

			public static JPanel EditMovieObjectCard (){
				
				System.out.println("EditMovieObjectCard - flag");
				JPanel card = new JPanel();
				
				card.add( new JLabel("Movie Functions. 2011"));
				
				try{
					Globals.ActiveMovie = Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID].MovieArray[Globals.ActiveMovieObjID];				
				}
				catch(ArrayIndexOutOfBoundsException e){
					Globals.ActiveMovie = new Movie();
				}
				
				JPanel part0 = new JPanel(); // Top details.
				JPanel partA = new JPanel(); // Movie Name.
				JPanel partB = new JPanel(); // Length,
				JPanel partZ = new JPanel(); // Submit buttons.
				
				
				part0.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
				partA.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
				partB.setPreferredSize(new Dimension(800,35));
				partZ.setPreferredSize(new Dimension(800,35));
						
				
				part0.add( new JLabel("Enter the revelent infomation for creating the Movie"));
				
				JLabel jlbName = new JLabel("Movie Name: (Required)");
				final JTextField jtxName = new JTextField(String.valueOf(Globals.ActiveMovie.Name),20);
				
				partA.add(jlbName);
				partA.add(jtxName);
				
				JLabel jlbLength = new JLabel("Length: (Must be a Number) ");
				final JTextField jtxLength = new JTextField(String.valueOf(Globals.ActiveMovie.Duration),20);
				
				partB.add(jlbLength);
				partB.add(jtxLength);
				
				
				
				JButton jbtU = new JButton("Update");
				JButton jbtA = new JButton("Apply");
				JButton jbtR = new JButton("Return");
				
				jbtU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						
						
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						
						boolean DataSafe = true;
						String Name = jtxName.getText();
						String Length = jtxLength.getText();
						
			
						if (Name.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
					
			
						try{
							
							int LengthInput = Integer.parseInt(Length);
							
							//System.out.println (AdultInput+ChildInput);
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						if (DataSafe == true){
							
							int LengthInput = Integer.parseInt(Length);
							
							Globals.ActiveMovie.Name = Name;
							Globals.ActiveMovie.Duration = LengthInput;
							
							// update ATA here.
							
							System.out.println("ActiveFlightObjID: " + Globals.ActiveFlightObjID);
							System.out.println("ActiveMovieObjID: " + Globals.ActiveMovieObjID);
							TravelGUI.ATAControl.EditMovieObject(Globals.ActiveMovie, Globals.ActiveFlightObjID, Globals.ActiveMovieObjID);
							
							CardLayout cl = (CardLayout)(Globals.cards.getLayout());
							cl.show(Globals.cards, Globals.LISTPANEL);
							
							Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
							
							
							
						}
						// System.out.println(DataSafe);
						
					}
				});
				
				jbtA.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						
						
						System.out.println("Flag Action Press - Sumbit");
						// Checks to see if the data is legal.
						
						boolean DataSafe = true;
						String Name = jtxName.getText();
						String Length = jtxLength.getText();
						
			
						if (Name.equals("")){
							System.out.println("Name Error");
							DataSafe = false;
						}
					
			
						try{
							
							int LengthInput = Integer.parseInt(Length);
							
							//System.out.println (AdultInput+ChildInput);
						}
						catch (NumberFormatException badstring){
							System.out.println("Number error");
							DataSafe = false;
						}
						
						if (DataSafe == true){
							
							int LengthInput = Integer.parseInt(Length);
							
							Globals.ActiveMovie.Name = Name;
							Globals.ActiveMovie.Duration = LengthInput;
							
							// update ATA here.
							
							System.out.println("ActiveFlightObjID: " + Globals.ActiveFlightObjID);
							System.out.println("ActiveMovieObjID: " + Globals.ActiveMovieObjID);
							TravelGUI.ATAControl.EditMovieObject(Globals.ActiveMovie, Globals.ActiveFlightObjID, Globals.ActiveMovieObjID);
						
							
							
						}
						// System.out.println(DataSafe);
						
					}
				});
				
				
				
				jbtR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Flag Action Press - Return");
						
						CardLayout cl = (CardLayout)(Globals.cards.getLayout());
						cl.show(Globals.cards, Globals.LISTPANEL);
					}
				});
				
				partZ.add(jbtU);
				partZ.add(jbtA);
				partZ.add(jbtR);
				
				card.add(part0);
				card.add(partA);
				
				card.add(partB);
				
				
				card.add(partZ);
				
				
				
				return card;
				
			}
			
		}

		
		
		public static JPanel BookObjectCard (){
			
			
			try{
				Globals.ActiveCustomer = Globals.ATA.CustomerArray[Globals.ActiveClientObjID];				
			}
			catch(ArrayIndexOutOfBoundsException e){
				Globals.ActiveCustomer = new Customer();
			}
									
			try{
				Globals.ActiveBusinessFlight = Globals.ATA.BusFlightArray[Globals.ActiveFlightObjID];	
				Globals.ActiveEconomyFlight = Globals.ATA.EcoFlightArray[Globals.ActiveFlightObjID];
			}
			catch(ArrayIndexOutOfBoundsException e){
				Globals.ActiveBusinessFlight = new BusinessFlight();
				Globals.ActiveEconomyFlight = new EconomyFlight();
				Globals.ActiveEconomyFlight.TravelDate = new Date();
				Globals.ActiveBusinessFlight.TravelDate = new Date();
			}
			
			
			
			
			
			JPanel card = new JPanel();
						
			JPanel part0 = new JPanel(); // Top details.
			JPanel partA = new JPanel(); // Client name for booking.
			JPanel partB = new JPanel(); // Flight ID
			JPanel partC = new JPanel(); // Default Children
			JPanel partD1 = new JPanel(); // Flight Details. ID
			JPanel partD2 = new JPanel(); // Flight Details. COST
			JPanel partD3 = new JPanel(); // Flight Details. FROM
			JPanel partD4 = new JPanel(); // Flight Details. TO
			JPanel partD5 = new JPanel(); // Flight Details. 
			JPanel partD6 = new JPanel(); // Flight Details.
			JPanel partE = new JPanel(); // Flight Type
			JPanel partZ = new JPanel(); // Submit buttons.
			
			
			part0.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partA.setPreferredSize(new Dimension(800,35)); // 25 is good for text boxes buttons needs at least 35.
			partB.setPreferredSize(new Dimension(800,35));
			partC.setPreferredSize(new Dimension(800,35));
			partD1.setPreferredSize(new Dimension(800,35));
			partD2.setPreferredSize(new Dimension(800,35));
			partD3.setPreferredSize(new Dimension(800,35));
			partD4.setPreferredSize(new Dimension(800,35));
			partD5.setPreferredSize(new Dimension(800,35));
			partE.setPreferredSize(new Dimension(800,35));
			partZ.setPreferredSize(new Dimension(800,35));
			
			part0.add( new JLabel("Welcome to the booking system."));

			JLabel jlbClientID = new JLabel("Client Name: ");
			final JLabel jtxClientID = new JLabel(String.valueOf(Globals.ActiveCustomer.CustomerCallName));
						
			partA.add(jlbClientID);
			partA.add(jtxClientID);
			
			JLabel jlbAdultNum = new JLabel("Number of Adults: ");
			final JTextField jtxAdultNum = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultadultSeats), 20);
			
			partB.add(jlbAdultNum);
			partB.add(jtxAdultNum);
			
			JLabel jlbChildNum = new JLabel("Number of Children: ");
			final JTextField jtxChildNum = new JTextField(String.valueOf(Globals.ActiveCustomer.DefaultchildSeats),20);
			
			partC.add(jlbChildNum);
			partC.add(jtxChildNum);
			
			JLabel jlbFlightDetail = new JLabel("Flight Details: Id Number: ");
			JLabel jtxFlightDetail = new JLabel(String.valueOf(Globals.ActiveEconomyFlight.FlightNumber));
			
			JLabel jtxFlightDetail2 = new JLabel("Ticket Cost: " + String.valueOf(Globals.ActiveEconomyFlight.FlightNumber));
			JLabel jtxFlightDetail3 = new JLabel("Date: " + String.valueOf(Globals.ActiveEconomyFlight.TravelDate));
			JLabel jtxFlightDetail4 = new JLabel("Origin: " + String.valueOf(Globals.ActiveEconomyFlight.origin));
			JLabel jtxFlightDetail5 = new JLabel("Destination: " + String.valueOf(Globals.ActiveEconomyFlight.destination));
			
			
			partD1.add(jlbFlightDetail);
			partD1.add(jtxFlightDetail);
			partD2.add(jtxFlightDetail2);
			partD3.add(jtxFlightDetail3);
			partD4.add(jtxFlightDetail4);
			partD4.add(jtxFlightDetail5);
			
			
			JLabel jlbFlightType = new JLabel("Flight Type: ");
			String[] FlightTypes = { "Economical", "Business",};
			final JComboBox TypeList = new JComboBox(FlightTypes);
			TypeList.setSelectedIndex(0);
			
			partE.add(jlbFlightType);
			partE.add(TypeList);
			//partD.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			
			
			
			JButton jbtS = new JButton("Sumbit");
			JButton jbtR = new JButton("Return");
			
			jbtS.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					String SelectedFlightType = (String) TypeList.getSelectedItem();
					int AdultSeats = Integer.parseInt(jtxAdultNum.getText()) ;
					int ChildSeats = Integer.parseInt(jtxChildNum.getText()) ;
					
					
					ATAControl.BookFlightObject(SelectedFlightType, AdultSeats, ChildSeats);
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.LISTPANEL);
				}
			});
			
			jbtR.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.LISTPANEL);
				}
			});
			
			partZ.add(jbtS);
			partZ.add(jbtR);
			
			card.add(part0);
			card.add(partA);
			card.add(partB);
			card.add(partC);
			card.add(partD1);
			card.add(partE);
			card.add(partD2);
			card.add(partD3);
			card.add(partD4);
			card.add(partD5);
			card.add(partZ);
			
			
			
			
			return card;
		}
		

		
		// Creates Menu Bar
		public static JMenuBar createMenuBar (){

			System.out.println("Flag 1 - Build Menu");
			JMenuBar menuBar; // The bar itself.
			JMenu menu; // Menu list object

			// Menu Item objects          
			JMenuItem menuItemInfo;
			JMenuItem menuItemSave;
			JMenuItem menuItemLoad;
			JMenuItem menuItemCreate;
			JMenuItem menuItemList;
			JMenuItem menuItemBook;
			JMenuItem menuItemQuit;

			//JRadioButtonMenuItem rbMenuItem;
			//JCheckBoxMenuItem cbMenuItem;

			//Create the menu bar.
			menuBar = new JMenuBar();

			//Build the first menu.
			menu = new JMenu("Functions");
			//menu.setMnemonic(KeyEvent.VK_A);
			//menu.getAccessibleContext().setAccessibleDescription(
			//        "The only menu in this program that has menu items");
			menuBar.add(menu);
			// THE BAR IS CREATED HERE OBJECTS ARE THEN ADDED TO THIS BAR BELOW


			//a group of JMenuItems
			menuItemInfo = new JMenuItem("About Program");
			menuItemLoad = new JMenuItem("Load File");
			menuItemSave = new JMenuItem("Save File");
			menuItemCreate = new JMenuItem("Debug");
			menuItemList = new JMenuItem("Object Manager");
			menuItemBook = new JMenuItem("Book Flight");
			menuItemQuit = new JMenuItem("Quit Program");
			//KeyEvent.VK_T);
			//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
			//menuItem.setAccelerator(KeyStroke.getKeyStroke(
			//        KeyEvent.VK_1, ActionEvent.ALT_MASK));
			//menuItem.getAccessibleContext().setAccessibleDescription(
			//        "This doesn't really do anything");

			menu.add(menuItemInfo);
			menu.add(menuItemCreate);
			menu.addSeparator();
			menu.add(menuItemLoad);
			menu.add(menuItemSave);
			menu.addSeparator();
			
			menu.add(menuItemList);
			menu.addSeparator();
			//menu.add(menuItemBook);
			//menu.addSeparator();
			menu.add(menuItemQuit);
			// MenuBar Reaction's

			menuItemInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press - 0");
					
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.INFOPANEL);
					
				}
			});
			
			menuItemCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					Debuging ();
					
				}
			});
			
			menuItemList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press");
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					
					Globals.listobjects = TravelGUI.ATAControl.RefreshList(Globals.listobjects);
					cl.show(Globals.cards, Globals.LISTPANEL);
					
				}
			});
			
			menuItemBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Flag Action Press");
					CardLayout cl = (CardLayout)(Globals.cards.getLayout());
					cl.show(Globals.cards, Globals.BOOKPANEL);
					 
				}
			});
			
			menuItemQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("System Halt via menu. Goodbye.");
					System.exit(0);
				}
			});
			// RETURNS THE CREATED MENU BAR.
			return menuBar;
		}
		
	}

	public static final class CodeTesting{ // Useless Code testing.

		// Testing global reaction Classes.
		class ActionTest implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println("Flag Action Press - ClassTest");
			}

		}
		class ListTest implements ListSelectionListener{

			public void valueChanged(ListSelectionEvent e) {
				
				System.out.println("Flag Action Press - ListvalueChanged");
				System.out.println("OBJECT ID: " + Globals.ActiveList.getSelectedIndex());
			}

		}
		
		class ChangeSelection implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed");
			}
 		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}








