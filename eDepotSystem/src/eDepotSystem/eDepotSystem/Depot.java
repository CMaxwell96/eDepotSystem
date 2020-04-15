package eDepotSystem;

import java.util.ArrayList;

public class Depot {

	private String depot;
	private List<Job> jobs = new ArrayList<Job>();
	private List<Driver> drivers = new ArrayList<Driver>();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	
	
	public Depot(String depot) {
		this.depot = depot;
		
	
	}
	
	public void addDriver(Driver driver) {
		//validate?
		
		drivers.add(driver);
			
	}
	
	public Driver getDriverByName(String name) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(name)){
				return d;
				
			}
			}
		//if no match
		return null;
		
		public void addVehicle(Vehicle vehicle) {
			//validate?
			
			vehicles.add(vehicle);
				
		}
		
		public Vehicle getVehicleByRegNo(String regno) {
			
			for (Vehicle v : vehicles) {
				if (v.getName().equals(regno)){
					return d;
					
				}
				}
			//if no match
			return null;
	}
		
		public void makeJob(Job job) {
			jobs.add(job);
			job.getDriver().makeJob(job);
			job.getVehicle().makeJob(job);
		
		}

		public void makeJob(String ref, Driver drivers, Vehicle vehicles, LocalDateTime jobStartDate) {
			
		}
}
