package eDepotSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Depot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 78777732009961041L;
	private String depotName;
	private String Location;
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
			// TODO Auto-generated method stub
			depots.add(depot);
		}
		public Object getLocation() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<Depot> getVehicles() {
			// TODO Auto-generated method stub
			return null;
		}
		public void Driver(int driverID, String userName, String password) {
		}
		

	
		}

