package eDepotSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import eDepotSystem.Vehicle;
import eDepotSystem.Driver;

public class WorkSchedule {

	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();

private String jobRef;
private int driverID;
private  String depotName;
private String vehicleReg;
private Vehicle vehicle;
private Driver driver;
private String client;
private LocalDateTime startDate;
private LocalDateTime endDate;
private Status status = Status.PENDING;
private boolean update = false;
private static List<Depot> depots = new ArrayList<Depot>();


 //method construction
public WorkSchedule(String jobRef, String client, String depotName, Driver driver, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotName = depotName;
	this.startDate = startDate;
	this.endDate = startDate;
	
	setVehicle(vehicle);
	setDriver(driver);
}
public WorkSchedule(String jobRef, String client, String depotName, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) throws Exception{
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotName = depotName;
	this.startDate = startDate;
	this.endDate = startDate;

	setVehicle(vehicle);
}
public WorkSchedule(String jobRef, String client, String depotName, Driver driver, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotName = depotName;
	this.startDate = startDate;
	this.endDate = startDate;
	
	setDriver(driver);
}

public WorkSchedule(String jobRef, String depotName, int driverID, String vehicleReg, LocalDateTime jobStartDate) {
	// TODO Auto-generated constructor stub
}
private Driver setDriver(Driver driver2) {
	return driver;
}

private Vehicle setVehicle(Vehicle vehicle2) {
	return vehicle;
}

public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public LocalDateTime getStartDate() {
	return startDate;
}
public void setStartDate(LocalDateTime startDate) {
	this.startDate = startDate;
}
public LocalDateTime getEndDate() {
	return endDate;
}
public void setEndDate(LocalDateTime endDate) {
	this.endDate = endDate;
}

public String toString(){
	return this.getClass().getSimpleName() + " >> " +
			jobRef + " " +
			depotName + " " +
			driverID + " " +
			vehicleReg + " " +
			client.toString()+" " +
			startDate.format(DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
}
public String getRegNo() {
	return vehicleReg;
	
}
public String getDepotName() {
	return depotName;
}

public int getDriverID() {
	return driverID;
	
}

private static void getDepots() {
	System.out.println("Here are a list of the Depots within the eDepot System : \n");
for(Depot depot : depots) {
	System.out.println(depot.getLocation());
}

}

private void getDepotLocation() {
	Scanner scan = new Scanner (System.in);
	String depotLocation = scan.nextLine();
	
	System.out.println(Depot.getDepotByLocation(depotLocation).toString());
}

public LocalDateTime getJobStartDate(){
	return startDate;
}

public String getJobRef() {
	return jobRef;
}

public Boolean isUpdate(){
	return update;
}

public void setUpdate(Boolean update){
	this.update = update;
}

public void makeJob(WorkSchedule job) {
	jobs.add(job);
	job.getDepotLocation();
	job.getDriverID();
	job.getRegNo();
	job.getClient();
	job.getStartDate();
	job.getEndDate();

}

public void makeJob(String jobRef, Depot location, Driver driverID, Vehicle vehicleReg, LocalDateTime jobStartDate) throws Exception {
	
}
public WorkSchedule getNextJob() {
	
	jobs.sort(Comparator.comparing(o -> o.getStartDate()));
	
	return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
	
}

public static WorkSchedule getJobRef(String jobRef) {
	
	
	for (WorkSchedule j: jobs) {
		if (j.getJobRef().equals(jobRef)){
			return j;
			
		}
		}
	return null;
}
}
