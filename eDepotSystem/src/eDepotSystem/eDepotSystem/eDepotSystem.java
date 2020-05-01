package eDepotSystem;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import eDepotSystem.Vehicle;
import eDepotSystem.Driver;

public class eDepotSystem {
	private final static String PATH = "C:\\Users\\Caolan\\eclipse-workspace\\eDepotSystem";
	static Scanner scan = new Scanner(System.in);
	static int inputNumber;
	private static List<Depot> depots = new ArrayList<Depot>();
	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();
	private static List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static Depot depot;
	
	
	public static void main(String[] args){
		//deSerialize();
//		depots.add(new Depot("London"));
//		depots.add(new Depot("Manchester"));
//		depots.add(new Depot("Liverpool"));
//		private static void displayMenu() {
//			logOn();
			
			//while(true){
				//depot = depots.get(0);
				
			//get the current depots location
				System.out.println("Welcome to the " + (Depot.getLocation() + " - eDepotSystem\n"));
				System.out.println("Below you will find the menu which shows which services are available on the system\n");
				System.out.println("Menu:");
				System.out.println("(1) View Depots");
				System.out.println("(2) Create New Job");
				System.out.println("(3) Reassign Depot");
				System.out.println("(4) View Schedule");
//				System.out.println("(2) View Jobs by Ref No.");
//				System.out.println("(3) View Drivers by ID");
//				System.out.println("(4) View Vehicles by Reg No.");
				System.out.println("(5) Create a new Job");
				System.out.println("(6) View Depots next job ");
				System.out.println("(Q) Quit ");
				
				String userChoice =scan.nextLine();
				
//				try {
//					inputNumber = Integer.parseInt(userChoice);
//				} catch (Exception e) {
//					System.out.println("Please enter a number to the left of the menu options");
//				}
				
				switch(userChoice) {
					case "1": 
						getDepotLocation();
						break;
					case "2": 
						makeJob();
						break;
					case "3": 
						getDriverByID();
						break;
					case "4": 
						getVehicleByReg();
						break;
					case "5": 
						makeJob();
						break;
					case "6": 
						getNextJob();
						break;
				}	
				
			while(!userChoice.equals("Q")) {
			//	Serialize();
				System.out.println("System End - Goodbye!");
				System.exit(0);
			}
			}
			//}
			

//		Driver driver1 = new Driver(001, "caolan", "_caolan");
//		Driver driver2 = new Driver(002, "curtis", "_curtis");
//		Driver driver3 = new Driver(003, "connor", "_connor");
//		
//		Vehicle vehicle1 = new Vehicle("Mercadecs", "2020", 5000, "NRG 2KI2");
		
//		WorkSchedule job1 = new WorkSchedule("Ref1", "Home Depot", 001, "NRG 2KI2", LocalDateTime.of(2020, 3,4, 9,30));
//	   depots.get(0).makeJob(job1);
//		
//		WorkSchedule job2 = new WorkSchedule("Ref2", "Away Depot", 002, "HAE 3USJ", LocalDateTime.of(2020, 5,7, 9,22));
//		depots.get(0).makeJob(job2);
		
//		for (Depot d : depots) {
//			d.startCheck();
//		}
//	}
	
	//This method will populate a 3 text files, the first try feature will add a users inputed depot to the depots array.
	private static void populate() throws FileNotFoundException {
		try(Scanner scan = new Scanner(new FileReader(PATH + "depots.txt"))){
		Depot depots = new Depot(scan.nextLine());
		depots.add(depot);
		
		//This try will allow the trucks.txt file to be populated with the trucks information and each of the variable to be split via period.
		try(Scanner scan2 = new Scanner(new FileReader(PATH + "trucks.txt"))){
			while (scan2.hasNext()) {
				String[] splits = scan2.nextLine().split(".");
				
				if (splits[0].equals(Depot.getLocation())) {
					depot.getVehicles().add( new Truck(splits[1], splits[2], Integer.valueOf(splits[3]), splits[4], Integer.valueOf(splits[5])));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage().isEmpty());
		}
	//This try will allow the tankers.txt file to be populated with the tankers information and each of the variable to be split via period.
		try(Scanner scan2 = new Scanner(new FileReader(PATH + "tankers.txt"))){
			while (scan2.hasNext()) {
				String[] splits2 = scan2.nextLine().split(".");
				
				if (splits2[0].equals(Depot.getLocation())) {
					depot.getVehicles().add( new Tanker(splits2[1], splits2[2], Integer.valueOf(splits2[3]), splits2[4], Integer.valueOf(splits2[5]), splits2[6]));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage().isEmpty());
		}
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	//This deserialization method will read the contents of the depo.ser file, allowing the stored values to be read and outputted from the previous execution
	private static void deSerialize() {
		ObjectInputStream ooS;
		
		try {
			ooS = new ObjectInputStream(new FileInputStream(PATH + "depot.ser"));
			depots = (List<Depot>)ooS.readObject();
			
			ooS.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	
//	 This serialization method will write inputed contents of the previously quitted system and store the values within the depot.ser file
	private static void Serialize() {
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH + "depot.ser"));
			oos.writeObject(depots);
			
			oos.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
		
//	private static void logOn() {
//		displayDepots();
		
//		System.out.println("Location: ");
//		String location = scan.nextLine();
//		
//		System.out.println("UserName: ");
//		String userName = scan.nextLine();
//		
//		System.out.println("Password: ");
//		String password = scan.nextLine();
//		
//		depot = getDepotByLocation(location);
//		if(depot != null) {
			
//			drivers = depot.getDriverByName(userName);
//			if(drivers != null) {
//				if(drivers.checkPassword(password)) {
//					if(Manager.class.isInstance(drivers)) {
//						manager = Manager.class.cast(drivers);
//						managerMenu();
//					}
//					else { 
//						driverMenu();
//					}
//				}
//			}
//		}
//		
//	}

	
	//This method will go through each value within the Depot array and output a list of the depot locations
	private static void getDepots() {
		System.out.println("Here are a list of the Depots within the eDepot System : \n");
	for(Depot depot : depots) {
		System.out.println(Depot.getLocation());
	}
	
	}
	
	//This method will allow the user to input a depots location, then output the depot location via the Depot array getlocation toString methods
	private static void getDepotLocation() {
		System.out.println("Enter Depot Location : ");
		String depotLocation = scan.nextLine();
		
		System.out.println(Depot.getDepotByLocation(depotLocation).toString());
	}
	
	//this method will require the job refference number that they wish to view, and the corresponding job ref is outputted
	private static void getJobRef() {
		System.out.println("Enter Job Ref number : ");
		String jobRef = scan.nextLine();
	
		System.out.println(WorkSchedule.getJobRef(jobRef).toString());
	}
	
	//this method will require the driver ID number,then output the drivers matching information from the Driver array
	private static void getDriverByID() {
		System.out.println("Enter Drivers ID : ");
		int driverID = scan.nextInt();
		
		System.out.println(Driver.getDriverByID(driverID).toString());
	}
	
	//this method will require the vehicle regestration as input, then output the matched vehicle information via the Vehicle Array
	private static  void getVehicleByReg() {
		System.out.println("Enter Vehicle Reg : ");
		String vehicleReg = scan.nextLine();
		
		System.out.println(Vehicle.getVehicleByRegNo(vehicleReg).toString());
	}
	
	//this method will create a new job based on user input and add those inputted values into a new work schedule via the depots.makeJob method
	private static void makeJob() {
		System.out.println("Enter the new Job Ref No. : ");
		String jobRef = scan.nextLine();
		
		System.out.println("Enter the Depots Location : ");
		String depotLocation = scan.nextLine();
		
		System.out.println("Enter the Driver ID : ");
		int driverID = scan.nextInt();
		
		System.out.println("Enter the Vehicle RegNo.: ");
		String vehicleReg = scan.nextLine();
		
		
		System.out.println("Enter the Job's creation date (dd mm yy HH:mm:)");
		LocalDateTime jobStartDate = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
		
		WorkSchedule jobs = WorkSchedule.getJobRef(jobRef);
		Depot depots = Depot.getDepotByLocation(depotLocation);
		Driver drivers = Driver.getDriverByID(driverID);
		Vehicle vehicles = Vehicle.getVehicleByRegNo(vehicleReg);
		depots.makeJob(new WorkSchedule(jobRef, depotLocation, driverID, vehicleReg, jobStartDate));
		
	
	}
	//this method will require a depots location and then output the chosen depots next scheduled job via the getNextJob and getJobStartDate
	private static void getNextJob() {
		System.out.println("Enter the Depot Location to see the next job date: ");
		String depotLocation = scan.nextLine();
	 
		
		System.out.println(Depot.getDepotByLocation(depotLocation).getNextJob().getJobStartDate().format(DateTimeFormatter.ofPattern("dd MM yy HH:mm")));
		
		
	}
}

