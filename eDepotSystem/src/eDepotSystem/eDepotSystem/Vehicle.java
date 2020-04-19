package eDepotSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vehicle implements Scheduleable {
	
	public String make;
	public String model;
	public int weight;
	public String RegNo;
	protected Boolean update = false;
	
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
	public WorkSchedule getNextJob() {
		
		jobs.sort(Comparator.comparing(o -> o.getStartDate()));
		
		return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
		
	}

	
	public Boolean isAvailable(LocalDateTime startDate, LocalDateTime endDate) {
		for (WorkSchedule j : jobs) {
			if ((j.getStartDate().isBefore(startDate))&&(j.getEndDate().isAfter(startDate))) {
				return false;
		}
			
		if ((j.getStartDate().isBefore(endDate))&&(j.getEndDate().isAfter(endDate))) {
		return false;
		}
		
		if ((j.getStartDate().isAfter(startDate))&&(j.getEndDate().isBefore(endDate)))
			return false;
		}
		return update;
	}

	public void addSchedule(WorkSchedule jobs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WorkSchedule> getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}
}
