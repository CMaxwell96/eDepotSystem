package eDepotSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Depot implements Serializable {


	private static final long serialVersionUID = 78777732009961041L;
	
	private static String location;
	private static List<Depot> depots = new ArrayList<Depot>();
	private List<WorkSchedule> jobs = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<Driver> drivers = new ArrayList<Driver>();
	private static List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	
	
	
	public Depot(String depot) {
		Depot.location = depot;
	
	}
	
	//This checks if there is a new job to be started every 30 seconds
	public void startCheck() {
	new Thread(new JobCheck(jobs,30)).start();	
	
	}
	
	
	
//	private static void getDepots() {
//		
//		System.out.println("Here are a list of the Depots within the eDepot System : \n");
//	for(Depot depot : depots) {
//		System.out.println(Depot.getLocation());
//	}
//	}
	
	
	//this is just to populate the Depot array with depot locations
	public void add(Depot depot) {
		depots.add(new Depot("London"));
		depots.add(new Depot("Manchester"));
		depots.add(new Depot("Liverpool"));
		depots.add(depot);
	}
	
	// the user should enter a chosen location and the corresponding Depot location will be outputted toString()
	public static String getLocation() {
		Scanner scan = new Scanner(System.in );
		System.out.println("Enter the Deopot Location : ");
		String depotLocation = scan.nextLine();
		
		System.out.println(Depot.getDepotByLocation(depotLocation).toString());
		return location;
	}
	
	// this will return the vehicle from the vehicle array that matches the users input
	public List<Vehicle> getVehicles() {
		Scanner scan = new Scanner(System.in );
		System.out.println("Enter the Vehicle Reg : ");
		String vehicleReg = scan.nextLine();
		
		System.out.println(Depot.getVehicleByRegNo(vehicleReg).toString());
		return vehicles;
	}
	
	//??
	public void Driver(int driverID, String userName, String password) {
	}
	


	//This will go through the Depot array and return idk because idk if it works
	public static Depot getDepotByLocation(String location) {
		
		for (Depot d : depots) {
			if (Depot.getLocation().equals(location)){
				return d;
				
			}
			}
		//if no match
		return null;
	}
	
	// this will add a driver to the Driver array?
	public void addDriver(Driver driver) {
		//validate?
		
		drivers.add(driver);	
	}
	
	//this will loop through the Drivers array a if the value equals the username via the getName method and return it
	public Driver getDriverByName(String userName) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(userName)){
				return d;
			}
			}
		//if no match
		return null;
	}
		
	//add a vehicle to the Vehicles array
		public void addVehicle(Vehicle vehicle) {
			//validate?
			
			vehicles.add(vehicle);
				
		}
		
		//this will loop through gthe vehicles array and retun the vehicle reg number
		public static Vehicle getVehicleByRegNo(String regno) {
			
			for (Vehicle v : vehicles) {
				if (v.getRegNo().equals(regno)){
					return v;
					
				}
				}
			//if no match
			return null;
	}
		
		// this is synced with the WorkSchedule class and will add each of the variables into the WorkSchedule array
		public synchronized void makeJob(WorkSchedule job) {
			jobs.add(job);
			job.getJobRef();
			job.getDepotName();
			job.getDriverID();
			job.getRegNo();
			job.getStartDate();
		}

		//i think this determines the structure of the job variables
		public void makeJob(String ref, Driver drivers, Vehicle vehicles, LocalDateTime jobStartDate) {
			
		}
		
		// this sorts the jobs in the WorkSchedule array by their start date, and returns the next job that is after the current date
		public WorkSchedule getNextJob() {
			
			jobs.sort(Comparator.comparing(o -> o.getStartDate()));
			
			return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
			
		}
}


