package eDepotSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Depot {

	private String depotName;
	private static List<Depot> depots = new ArrayList<Depot>();
	private List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();
	private List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	
	
	public Depot(String depot) {
		this.depotName = depot;
		
	
	}
	public String getDepotName() {
		return depotName;
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
	
	public Driver getDriverByID(String ID) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(ID)){
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
		
		
		public void makeJob(WorkSchedule job) {
			jobs.add(job);
			job.getDriverID();
			job.getRegNo();
		
		}

		public void makeJob(String ref, Driver drivers, Vehicle vehicles, LocalDateTime jobStartDate) {
			
		}
		public WorkSchedule getNextJob() {
			
			jobs.sort(Comparator.comparing(o -> o.getStartDate()));
			
			return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
			
		}


	
		}

