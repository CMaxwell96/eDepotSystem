package eDepotSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Depot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 78777732009961041L;
	private String depotName;
	private static String Location;
	private static List<Depot> depots = new ArrayList<Depot>();
	private List<WorkSchedule> jobs = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	
	
	
	public Depot(String depot) {
		this.depotName = depot;
		
	
	}
	public void startCheck() {
		
	new Thread(new JobCheck(jobs,30)).start();	
	}
	
	public String getDepotName() {
		return depotName;
	}
	
	private static void getDepots() {
		System.out.println("Here are a list of the Depots within the eDepot System : \n");
	for(Depot depot : depots) {
		System.out.println(depot.getLocation());
	}
	
	}
	
	private static void getDepotLocation() {
		Scanner scan = new Scanner(System.in );
		String depotLocation = scan.nextLine();
		
		System.out.println(Depot.getDepotByName(depotLocation).toString());
	}
	
	public static Depot getDepotByName(String depotName) {
		
		for (Depot d : depots) {
			if (d.getDepotName().equals(depotName)){
				return d;
				
			}
			}
		//if no match
		return null;
	}
	

	public void addDriver(Driver driver) {
		//validate?
		
		drivers.add(driver);
			
	}
	
	public Driver getDriverByName(String userName) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(userName)){
				return d;
				
			}
			}
		//if no match
		return null;
	}
		
		public void addVehicle(Vehicle vehicle) {
			//validate?
			
			vehicles.add(vehicle);
				
		}
		
		public Vehicle getVehicleByRegNo(String regno) {
			
			for (Vehicle v : vehicles) {
				if (v.getRegNo().equals(regno)){
					return v;
					
				}
				}
			//if no match
			return null;
	}
		
		
		public synchronized void makeJob(WorkSchedule job) {
			jobs.add(job);
			job.getJobRef();
			job.getDepotName();
			job.getDriverID();
			job.getRegNo();
			job.getStartDate();
		
			
		}

		public void makeJob(String ref, Driver drivers, Vehicle vehicles, LocalDateTime jobStartDate) {
			
		}
		public WorkSchedule getNextJob() {
			
			jobs.sort(Comparator.comparing(o -> o.getStartDate()));
			
			return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
			
		}
		public void add(Depot depot) {
			
			depots.add(new Depot("London"));
			depots.add(new Depot("Manchester"));
			depots.add(new Depot("Liverpool"));
			depots.add(depot);
		}
		public static Object getLocation() {
			return depots;
		}
		public List<Vehicle> getVehicles() {
			return vehicles;
		}
		
		public void Driver(int driverID, String userName, String password) {
		}
		

	
		}

