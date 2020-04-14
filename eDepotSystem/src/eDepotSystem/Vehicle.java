package eDepotSystem;

import java.util.List;

public class Vehicle {
	
	//instance fields
	public String depotName; 	// Name of depot located at
	public String location;  	// Actual Location
	public int driverID;		// DriverID	
	public int DepotID;
	public String make;
	public String model;
	public int weight;
	public String RegNo;
	
	public static boolean IsAvailable;
	
	//protected List<Job> jobs = new ArrayList<Job>();
	
	public Vehicle () {
		
	
	}
	
	
	
	public String getDepotName() {
		return depotName;
	}



	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getDriverID() {
		return driverID;
	}



	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}



	public int getDepotID() {
		return DepotID;
	}



	public void setDepotID(int depotID) {
		DepotID = depotID;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public String getRegNo() {
		return RegNo;
	}



	public void setRegNo(String regNo) {
		RegNo = regNo;
	}



	public String toString() {
        return  " Make:" +this.depotName + " Tanker Model:" + this.location + " Tanker RegNo:" + this.driverID + " DepotID: " + this.DepotID + " Make: " + this.make + " Model: " + this.model + " Weight: " + this.weight + " RegNO: " + this.RegNo;
    }
	
	//public void makeJob(Job jobDateTime) {
	//	jobs.add(jobDateTime);
		
	//}
	
	//public Job getNextJob() {
		
	//	jobs.sort(Comparator.comparing(o -> o.getStartDate()));
		
	//	return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
		
	//}

	

}
