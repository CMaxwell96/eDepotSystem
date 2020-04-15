package eDepotSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vehicle {
	
	//instance fields
	
	public String make;
	public String model;
	public int weight;
	public String RegNo;
	public static boolean IsAvailable;
	
	protected List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();
	private static List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	public Vehicle (String make,String model, int weight, String RegNo) {
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.RegNo = RegNo;
	
	}
	
	public String getMake() {
		return make;
		
	}
	
	public String getModel() {
		return model;
		
	}
	
	public int getWeight() {
		return weight;
		
	}
	
	public String getRegNo() {
		return RegNo;
		
	}
	
	public void makeJob(WorkSchedule jobDateTime) {
		jobs.add(jobDateTime);
		
	}

	public static Vehicle getVehicleByRegNo(String regno) {
		
		for (Vehicle v : vehicles) {
			if (v.getRegNo().equals(regno)){
				return v;
				
			}
			}
		//if no match
		return null;
}
//	public WorkSchedule getNextJob() {
//		
//		jobs.sort(Comparator.comparing(o -> o.getStartDate()));
//		
//		return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
//		
//	}

	

}
