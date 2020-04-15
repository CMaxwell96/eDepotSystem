package eDepotSystem;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import eDepotSystem.Vehicle;
import eDepotSystem.Driver;

public class eDepotSystem {
	static Scanner scan = new Scanner(System.in);
	static int inputNumber;
	private static List<Depot> depots = new ArrayList<Depot>();
	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();
	private static List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static Depot depot;
	
	public static void main(String[] args) {
		
		displayMenu();

		
	}
	
	private static void displayMenu() {
		
		while(true){
			System.out.println("Welcome to the eDepotSystem\n");
			System.out.println("Below you will find the menu which shows which services are available on the system\n");
			System.out.println("Menu:");
			System.out.println("(1) View Depots by name");
			System.out.println("(2) View Jobs by Ref No.");
			System.out.println("(3) View Drivers by ID");
			System.out.println("(4) View Vehicles by Reg No.");
			System.out.println("(5) Create a new Job");
			System.out.println("(6) View Depots next job ");
			String userChoice =scan.nextLine();
			
			try {
				inputNumber = Integer.parseInt(userChoice);
			} catch (Exception e) {
				System.out.println("Please enter a number to the left of the menu options");
			}
			
			switch(inputNumber) {
				case 1: 
					getDepotByName();
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
			}
		
		}
	
	private static void getDepotByName() {
		System.out.println("Enter Depots Name : ");
		String depotName = scan.nextLine();
		
		System.out.println(Depot.getDepotByName(depotName).toString());
	}
	
	private static void getJobRef() {
		System.out.println("Enter Job Ref number : ");
		String jobRef = scan.nextLine();
		
		System.out.println(WorkSchedule.getJobRef(jobRef).toString());
	}
	private static void getDriverByID() {
		System.out.println("Enter Drivers ID : ");
		String driverID = scan.nextLine();
		
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
		String driverID = scan.nextLine();
		
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
