import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import graph.Graph;


public class weighted extends Graph {

	private int[ ][ ] lengths;
	int Travel_Time[ ][ ];
	int Path[];
	List <String> NodeNames;
	
	public weighted(int n) {
		super(n);
		// TODO Auto-generated constructor stub
		lengths = new int[n][n];  // All values initially false
		Travel_Time = new int[n][n]; // A counter for the time spent traveling.
		Path = new int[n+1]; // Shortest Path and distance of that.
		NodeNames  = new LinkedList<String>();  
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		weighted w = new weighted(6);
		
		//w.addEdge(0, 1,100,true);
		//w.addEdge(0, 2,100,true);
		//w.addEdge(1, 3,100,true);
		//w.addEdge(2, 3,500,true);
		//w.addEdge(3, 4,100,true);
		//w.addEdge(3, 4,100,true);
		//w.addEdge(4, 5,100,true);
		//w.addEdge(4, 6,100,true);
		
		//w.setLabel(0, "Sydney");
		//w.setLabel(1, "Mudgee");		
		//w.setLabel(2, "Bathurst");
		//w.setLabel(3, "Ligthow");
		//w.setLabel(4, "Wagga");
		//w.setLabel(5, "Coola");
		//w.setLabel(6, "Rockhampt");
		
		
		//System.out.println(w.isEdge(0, 2));		
		//Graph.depthFirstPrint(w, 0);
		//int set[] = w.neighbors(3);
		//for (int i = 0; i < set.length; i++){
		//	System.out.println(": "+set[i]);
			
		//}
		
		
		
		//FindShortDistance(w,0,4);
		
		userinput();
		
		
		
		
				
	}
	
	private static void userinput () {
		//FindShortPath(w,3,4);
		
		weighted w = readMyFile("paths.txt");

		System.out.println("Locations:");
		
		for (int i = 0;i < w.NodeNames.size() ;i++){
			System.out.print(i+1+" ");
			System.out.println(w.NodeNames.get(i));
		}
		
		System.out.println("Which Location are you traveling from: ");
		Scanner user_input = new Scanner( System.in );
		String command;
		System.out.print(":> ");
		command = user_input.next( );
		
		int LocationA = Integer.parseInt(command);

		System.out.println("Which Location are you traveling To: ");
		System.out.print(":> ");
		command = user_input.next( );
		
		int LocationB = Integer.parseInt(command);
		
		System.out.println("Which Travel Method: 1. Shortest path (ignores distance) 2. Shortest Distance (takes into account distance) ");
		System.out.print(":> ");
		command = user_input.next( );
		
		int method_type = Integer.parseInt(command);
		
		if (method_type == 1){
			FindShortPath(w,LocationA,LocationB);
		}else if (method_type == 2){
			FindShortDistance(w,LocationA,LocationB);
		}
		
		
		
		System.out.println("");
		System.out.println("Again? (y)");
		System.out.print(":> ");
		command = user_input.next( );
		
		if (command.matches("y")){
			userinput();
		}
		
		user_input.close();
		
	}
	

	public int getEdgeLength(int i,int j){
		
		return lengths[i][j];
		
	}
	
	
	
	private void addEdge(int i, int j, int length, boolean isbothways) {
		// TODO Auto-generated method stub
		if (isbothways == true){
		
			super.addEdge(i, j);
			super.addEdge(j, i);
			lengths[i][j] = length;
			lengths[j][i] = length;
		}
		else {
		
			super.addEdge(i, j);
			lengths[i][j] = length;
		
		
		}
	}

	
	public void removeEdge(int source, int target) {
		// TODO Auto-generated method stub
		super.removeEdge(source, target);
		lengths[source][target] = 0;
		
	}

	private static weighted Travel(weighted w, int current_loc,int pre_loc,int final_location,int TIME_TRAVED_SO_FAR,int Path[], int Step_cycle){
		
		int internalPath[] = new int[Path.length+1];
		internalPath[Path.length] = current_loc;
		for(int i = 0;i < Path.length ;i++){
			internalPath[i] = Path[i];
			//System.out.println(internalPath[i]);
		}
		
		if (current_loc == final_location){
			int FinalPath[] = new int[internalPath.length];
			FinalPath[Path.length] = final_location;
			//System.out.println(">");
			for(int i = 0;i < internalPath.length ;i++){
				FinalPath[i] = internalPath[i];
				//System.out.print(FinalPath[i]);
				//System.out.print(" . ");
			}
			//System.out.print(TIME_TRAVED_SO_FAR);
			FinalPath[0] = TIME_TRAVED_SO_FAR;
			//System.out.print(FinalPath[w.size()-1]);
			if (w.Path[0] == 0 || w.Path[0] > FinalPath[0]){
				w.Path = FinalPath;
			}
			return w;
		}
		for (int i = 0; i < w.size() ; i++){
			for (int i2 = 0; i2 < w.size() ; i2++){
				if (w.getEdgeLength(i,i2) > 0){
					//System.out.println("A Path");
					boolean safe = true;
					for(int o = 1;o < Path.length;o++){
						if (Path[o] == i2){
							safe = false;
						}
					}				
					if (current_loc == i && safe == true){
						//System.out.println(" ");
						//System.out.println("LOC:" + i + " TO: " + i2 + "(..."+TIME_TRAVED_SO_FAR+")");
						//System.out.println("Length Details:"+w.getEdgeLength(i,i2));
						//System.out.println("AVAILABLE CHOICE FOR TRAVEL");
						//System.out.println(">: " + w.getEdgeLength(i, i2)+ " : Distance to travel though this link");
						//System.out.println(">: "+w.Travel_Time[i][i2]+ " : CURRENT TRAVEL_TIME : 'zero' = NEW PATH");
						if (w.Travel_Time[i][i2] == 0 || w.Travel_Time[i][i2] < w.getEdgeLength(i, i2)){
							//System.out.println("CURRENT PATH IS SHORTER");
							w.Travel_Time[i][i2] = TIME_TRAVED_SO_FAR + w.getEdgeLength(i, i2);
							//System.out.println("TRAVEL TIME MARKED");
							//System.out.println(">: " + w.Travel_Time[i][i2]+" : NEW TRAVEL TIME");
						}
						else {
							//System.out.println("CURRENT PATH IS LONGER : NO CHANGE");
							//System.out.println(">: " + w.Travel_Time[i][i2]+" : OLD TRAVEL TIME");
							return w;
						}
						Step_cycle++;
						Travel(w,i2,current_loc,final_location,w.Travel_Time[i][i2],internalPath,Step_cycle);
					}
				}	
			}
		}
		return w;
	}
	
	
	private static weighted count_Point(weighted w, int current_loc,int pre_loc,int final_location,int Path[], int Step_cycle){
		
		int internalPath[] = new int[Path.length+1];
		internalPath[Path.length] = current_loc;
		
		for(int i = 0;i < Path.length ;i++){
			internalPath[i] = Path[i];
			//System.out.println(internalPath[i]);
			
		}
		
		
		if (current_loc == final_location){	
			int FinalPath[] = new int[internalPath.length];
			FinalPath[Path.length] = final_location;
			for(int i = 0;i < internalPath.length ;i++){
				//System.out.print(FinalPath[i]);
				//System.out.print(" ");
				
				FinalPath[i] = internalPath[i];
			}
			FinalPath[0] = FinalPath.length-2;

			if (w.Path[0] == 0 || w.Path[0] > FinalPath[0]){
				
				w.Path = FinalPath;
				
			}
			return w;
		}
		
		for (int i = 0; i < w.size() ; i++){
			for (int i2 = 0; i2 < w.size() ; i2++){

				if (w.getEdgeLength(i,i2) > 0){
					boolean safe = true;
					for(int o = 1;o < Path.length;o++){
						if (Path[o] == i2){
							safe = false;
						}
					}				
					
					if (current_loc == i && safe == true){
						//System.out.println(" ");
						//System.out.println("LOC:" + i + " TO: " + i2);
						//System.out.println("Length Details:"+w.getEdgeLength(i,i2));
						//System.out.println("AVAILABLE CHOICE FOR TRAVEL");
						//System.out.println(">: " + w.getEdgeLength(i, i2)+ " : Distance to travel though this link");
						//System.out.println(">: "+w.Travel_Time[i][i2]+ " : CURRENT TRAVEL_TIME : 'zero' = NEW PATH");
						
						//Difference from full code
						if (Step_cycle < w.Path.length){
							// do nothing.
							
							//System.out.println("CURRENT PATH IS SHORTER");
							//System.out.println(">: " + w.Travel_Time[i][i2]+" : NEW TRAVEL TIME");						
						}
						else {
							//System.out.println("CURRENT PATH IS LONGER : NO CHANGE");
							//System.out.println(">: " + w.Travel_Time[i][i2]+" : OLD TRAVEL TIME");
							return w;
						}
						Step_cycle++;
						count_Point(w,i2,current_loc,final_location,internalPath,Step_cycle);
					}
				}	
			}
		}
		return w;
	}

	/**
	 * Path ignores travel distance values when working out the path
	 * 
	 * @param w
	 * @param first
	 * @param second
	 * @return
	 */
	public static int[]  FindShortPath(weighted w, int first, int second){
		
		int Path[] = new int[1];
		
		w.Path = new int[w.size()]; // Shortest Path and distance of that. 
		
		System.out.print("Processing Path...");
		w = count_Point(w,first,-1,second,Path,0);
		System.out.println(" ... Path Found!!");

		
		System.out.println(" ");
		System.out.println(" # ");
		
		for (int i = 0;i < w.Path.length;i++){
			System.out.print(" ");
			System.out.print(w.Path[i]);
		}
		
		return w.Path;
		
	}
	
	/**
	 * Distance takes into account of the distance between each point
	 * 
	 * @param w
	 * @param first
	 * @param second
	 * @return
	 */
	public static int[]  FindShortDistance(weighted w, int first, int second){
		
		int Path[] = new int[1];
		w.Path = new int[w.size()]; // Shortest Path and distance of that.
		
		System.out.print("Processing Path...");
		w = Travel(w,first,-1,second,0,Path,0);
		System.out.println(" ... Path Found!!");
		System.out.println(" ");
		System.out.println(" # ");
		
		for (int i = 0;i < w.Path.length;i++){
			System.out.print(" ");
			System.out.print(w.Path[i]);
		}
		
		
		
		return w.Path;
		
	}
	
	// LOADS FILE A
	// LOADS FILE B
	
	// FILE LOADED PICK LOCATION YOU ARE TRAVING FROM
	// PICK LOCATION YOU ARE TRAVING TO 
	
	// SHORTEST PATH OR SHORTEST DISTANCE.

	// HERE IS WHAT YOU WANT TO KNOW? WANT SOMETHING ELSE?
	
	public static weighted readMyFile(String FileName){
			
		System.out.println("BEGIN READ FILE");
		
		weighted w = null;
		
		String record = null;
		String recordArray [] = null; 
		String linesplit = " ";

		try {
			FileReader dataSize = new FileReader(FileName);
			BufferedReader LineCounterBuffer = new BufferedReader(dataSize);
			
			w = new weighted(0);
			
			int size = -1;
			int counter = 0; 
			// Find File Size
			//int FileLength = 0;
			//while ((record = LineCounterBuffer.readLine()) != null) {
			//	FileLength++;
			//	}
			//System.out.println("File Size is: " + FileLength + " Lines Long.");

			//Using the FileLenght Create an Array to hold the subjects.
			//int objects[][] = new int[FileLength][FileLength];			

			// Read File Into Student [] Array.
			FileReader Subjectdata = new FileReader("paths.txt");
			BufferedReader SubjectReadBuffer = new BufferedReader(Subjectdata);
			record = new String();

			// File Length is looped to each array placement.
			//FileLength = 0;
			while ((record = SubjectReadBuffer.readLine()) != null) {
			
				// Read and split the lines and insert them as required
				
				
				recordArray = record.split(linesplit);
				
				//for (int i = 0; i < recordArray.length; i++){
					
					if (size == -1){
						size = Integer.parseInt(recordArray[0]);
						
						//System.out.println(recordArray[i]);
						w = new weighted(size);
					}else if (size >= 0 && counter < size){
						
						System.out.println(recordArray[0]);
						System.out.println(recordArray[1]);
						System.out.println(recordArray[2]);
						
						w.addEdge(Integer.parseInt(recordArray[0]), Integer.parseInt(recordArray[1]), Integer.parseInt(recordArray[2]), true);
						
						
						counter ++;
					}else if (counter == size){
						loadnamestxt(w,recordArray[0]);						
					}
					
				//}
				
				
				
				} 
			// After this while loop all Subjects are loaded correctly into the global method.
			LineCounterBuffer.close();
			SubjectReadBuffer.close();
			
		} catch (IOException e){
			// catch possible io errors from readLine()
			System.out.println("File not Found.");
			e.printStackTrace();
		}
		return w;
	}
	
	private static weighted loadnamestxt(weighted w, String FileName){
		
		
		System.out.println("BEGIN READ NAMES");
			
		// config
		String record = null;
		String recordArray [] = null; 
		String linesplit = " ";

		try {
			FileReader dataSize = new FileReader(FileName);
			BufferedReader LineCounterBuffer = new BufferedReader(dataSize);
			
			FileReader Subjectdata = new FileReader(FileName);
			BufferedReader SubjectReadBuffer = new BufferedReader(Subjectdata);
			record = new String();

			
			
			while ((record = SubjectReadBuffer.readLine()) != null) {

				recordArray = record.split(linesplit);
				//System.out.println(recordArray[0]);
				System.out.println(recordArray[1]);
				
				w.NodeNames.add(recordArray[1]);
				
				//w.setLabel(Integer.parseInt(recordArray[0]), recordArray[1]);
				}

			LineCounterBuffer.close();
			SubjectReadBuffer.close();
			
		} catch (IOException e){
			System.out.println("File not Found.");
			e.printStackTrace();
		}
		return w;
	}
	
}
