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
	private final static String PATH = "M:\\data\\eDepotSystem";
	static Scanner scan = new Scanner(System.in);
	static int inputNumber;
	private static List<Depot> depots = new ArrayList<Depot>();
	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();
	private static List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static Depot depot;
	
	
	public static void main(String[] args) {
		deSerialize();
		depots.add(new Depot("London"));
		depots.add(new Depot("Manchester"));
		depots.add(new Depot("Liverpool"));
		displayMenu();

		Driver driver1 = new Driver(001, "caolan", "_caolan");
		Driver driver2 = new Driver(002, "curtis", "_curtis");
		Driver driver3 = new Driver(003, "connor", "_connor");
		
		Vehicle vehicle1 = new Vehicle("Mercadecs", "2020", 5000, "NRG 2KI2");
		
//		WorkSchedule job1 = new WorkSchedule("Ref1", "Home Depot", 001, "NRG 2KI2", LocalDateTime.of(2020, 3,4, 9,30));
//	   depots.get(0).makeJob(job1);
//		
//		WorkSchedule job2 = new WorkSchedule("Ref2", "Away Depot", 002, "HAE 3USJ", LocalDateTime.of(2020, 5,7, 9,22));
//		depots.get(0).makeJob(job2);
		
//		for (Depot d : depots) {
//			d.startCheck();
//		}
	}
	
	@SuppressWarnings("unchecked")
	private void populate() throws FileNotFoundException {
		try(Scanner scan = new Scanner(new FileReader(PATH + "depots.txt"))){
		Depot depots = new Depot(scan.nextLine());
		depots.add(depot);
		try(Scanner scan2 = new Scanner(new FileReader(PATH + "trucks.txt"))){
			while (scan2.hasNext()) {
				String[] splits = scan2.nextLine().split(".");
				
				if (splits[0].equals(depot.getLocation())) {
					depot.getVehicles().add( new Truck(splits[1], splits[2], Integer.valueOf(splits[3]), splits[4], Integer.valueOf(splits[5])));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage().isEmpty());
		}
		try(Scanner scan2 = new Scanner(new FileReader(PATH + "tankers.txt"))){
			while (scan2.hasNext()) {
				String[] splits2 = scan2.nextLine().split(".");
				
				if (splits2[0].equals(depot.getLocation())) {
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


	private static void displayMenu() {
//		logOn();
		
		while(true){
			depot = depots.get(0);
			
			System.out.println("Welcome to the " + (Depot.getLocation() + " - eDepotSystem\n"));
			System.out.println("Below you will find the menu which shows which services are available on the system\n");
			System.out.println("Menu:");
			System.out.println("(1) View Depots by name");
			System.out.println("(2) View Jobs by Ref No.");
			System.out.println("(3) View Drivers by ID");
			System.out.println("(4) View Vehicles by Reg No.");
			System.out.println("(5) Create a new Job");
			System.out.println("(6) View Depots next job ");
			System.out.println("(Q) Quit ");
			
			String userChoice =scan.nextLine();
			
			try {
				inputNumber = Integer.parseInt(userChoice);
			} catch (Exception e) {
				System.out.println("Please enter a number to the left of the menu options");
			}
			
			switch(inputNumber) {
				case 1: 
					getDepots();
					break;
				case 2: 
					getJobRef();
					break;
				case 3: 
					getDriverByID();
					break;
				case 4: 
					getVehicleByReg();
					break;
				case 5: 
					makeJob();
					break;
				case 6: 
					getNextJob();
					break;
			}	
			
		while(!userChoice.equals("Q")) {
			Serialize();
			System.out.println("System End - Goodbye!");
			System.exit(0);
		}
		}
		}
	
	private static void getDepots() {
		System.out.println("Here are a list of the Depots within the eDepot System : \n");
	for(Depot depot : depots) {
		System.out.println(Depot.getLocation());
	}
	
	}
	
	private static void getDepotLocation() {
		
		String depotLocation = scan.nextLine();
		
		System.out.println(Depot.getDepotByName(depotLocation).toString());
	}
	
	private static void getJobRef() {
		System.out.println("Enter Job Ref number : ");
		String jobRef = scan.nextLine();
		
		System.out.println(WorkSchedule.getJobRef(jobRef).toString());
	}
	private static void getDriverByID() {
		System.out.println("Enter Drivers ID : ");
		int driverID = scan.nextInt();
		
		System.out.println(Driver.getDriverByID(driverID).toString());
	}
	private static  void getVehicleByReg() {
		System.out.println("Enter Vehicle Reg : ");
		String vehicleReg = scan.nextLine();
		
		System.out.println(Vehicle.getVehicleByRegNo(vehicleReg).toString());
	}
	
	
	private static void makeJob() {
		System.out.println("Enter the new Job Ref No. : ");
		String jobRef = scan.nextLine();
		
		System.out.println("Enter the Depots Name : ");
		String depotName = scan.nextLine();
		
		System.out.println("Enter the Driver ID : ");
		int driverID = scan.nextInt();
		
		System.out.println("Enter the Vehicle RegNo.: ");
		String vehicleReg = scan.nextLine();
		
		WorkSchedule jobs = WorkSchedule.getJobRef(jobRef);
		Depot depots = Depot.getDepotByName(depotName);
		Driver drivers = Driver.getDriverByID(driverID);
		Vehicle vehicles = Vehicle.getVehicleByRegNo(vehicleReg);
		
		System.out.println("Enter the Job's creation date (d mm yy HH:mm:");
		LocalDateTime jobStartDate = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
		
		depots.makeJob(new WorkSchedule(jobRef, depotName, driverID, vehicleReg, jobStartDate));
		
	
	}
	private static void getNextJob() {
		System.out.println("Enter the Depot Name to see the next job date: ");
		String depotName = scan.nextLine();
	 
		
		System.out.println(Depot.getDepotByName(depotName).getNextJob().getJobStartDate().format(DateTimeFormatter.ofPattern("dd MM yy HH:mm")));
		
		
	}
}

