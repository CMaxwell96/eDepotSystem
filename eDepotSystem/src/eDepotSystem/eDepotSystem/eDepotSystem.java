package eDepotSystem;

import java.util.Scanner;

public class eDepotSystem {
	static Scanner scan = new Scanner(System.in);
	static int inputNumber;
	private List<Depot> depots = new ArrayList<Depot>();
	private Depot depot;
	
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
	
	private void getDepotByName() {
		System.out.println("Enter Depots Name : ");
		String depotName = scan.nextLine();
		
		System.out.printl n(depots.getDepotByName(depotName).toString());
	}
	
	private void getJobRef() {
		System.out.println("Enter Job Ref number : ");
		String jobRef = scan.nextLine();
		
		System.out.println(depots.getJobRef(jobRef).toString());
	}
	private void getDriverByID() {
		System.out.println("Enter Drivers ID : ");
		String driverID = scan.nextLine();
		
		System.out.println(depots.getDriverByID(driverID).toString());
	}
	private void getVehicleByReg() {
		System.out.println("Enter Vehicle Reg : ");
		String vehicleReg = scan.nextLine();
		
		System.out.println(depots.getVehicleByReg(vehicleReg).toString());
	}
	
	
	private void makeJob() {
		System.out.println("Enter the new Job Ref No. : ");
		String ref = scan.nextLine();
		
		System.out.println("Enter the Depots Name : ");
		String depotName = scan.nextLine();
		
		System.out.println("Enter the Driver ID : ");
		String driverID = scan.nextLine();
		
		System.out.println("Enter the Vehicle RegNo.: ");
		String vehicleReg = scan.nextLine();
		
		Job jobs = depots.getJobRef(ref);
		Depot depots = depots.getDepotByName(depotName);
		Driver drivers = depots.getDriverByID(driverID);
		Vehicle vehicles = depots.getVehicleByReg(vehicleReg);
		
		System.out.println("Enter the Job's creation date (d mm yy HH:mm:");
		LocalDateTime jobStartDate = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
		
		depots.makeJob(new Job(ref, depotName, driverID, vehicleReg, jobStartDate));
		
	
	}
	private void getNextJob() {
		System.out.println("Enter the Depot Name to see the next booking : ");
		String depotName = scan.nextLine();
	 
		
		System.out.println(depots.getDepotByName(depotName).getNextJob().getJobDateTime().format(DateTimeFormatter.ofPattern("dd MM yy HH:mm")));)
		
		
	}
	
}
