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

	public final String SEP = (",");
private String jobRef;
private int driverID;
private  String depotLocation;
private String vehicleReg;
private Vehicle vehicle;
private Driver driver;
private String client;
private static LocalDateTime startDate;
private static LocalDateTime endDate;
private String status;
private boolean update = false;
private static List<Depot> depots = new ArrayList<Depot>();

public WorkSchedule(String csvString) { // reading the strings into an array
	String[] csvParts = parseCSV(csvString); // csvString.split(SEP, -1);
	int i = 0;
	jobRef = csvParts[i++];
	depotLocation = csvParts[i++];
	driverID = safeParse(csvParts[i++]);
	startDate = safeParseLDT(csvParts[i++]);
	endDate = safeParseLDT(csvParts[i++]);
	status = (csvParts[i++]);
}

public String toWSCSVString() { // how the strings will be formatted if all were printed and how they can be
	// called from the array list
return jobRef + SEP + depotLocation + SEP
+ driverID + SEP + startDate + SEP + endDate + SEP + status;

}

	public static String[] parseCSV(String csv) {
		String[] split = new String[0];

		ArrayList<String> strings = new ArrayList<>();
		boolean inQuotes = false;
		String currentString = "";
		for (char c : csv.toCharArray()) {
			
			if (c == '\"') { // switch modes = in quotes or not
				inQuotes = !inQuotes;
				continue;
			}
			
			if (!inQuotes && c == ',') { //if a comma, but not in quotes 
				strings.add(currentString); // add to list of output strings
				currentString = ""; // blank "current" string
				continue;
			}
						
			currentString = currentString + c; // concatenate current string

		}
		strings.add(currentString);
		
		split = new String[strings.size()];
		split = strings.toArray(split);

		return split;
	}

	public static int safeParse(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}

	}
	
	public static LocalDateTime safeParseLDT(String str) {
		try {
			return LocalDateTime.parse(str);
		} catch (Exception e) {
			return startDate ;
		}

	}
	
 //method construction for the work schedule array
public WorkSchedule(String jobRef, String client, String depotLocation, Driver driver, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotLocation = depotLocation;
	this.startDate = startDate;
	this.endDate = endDate;
	
	setVehicle(vehicle);
	setDriver(driver);
}
public WorkSchedule(String jobRef, String client, String depotLocation, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) throws Exception{
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotLocation = depotLocation;
	this.startDate = startDate;
	this.endDate = endDate;

	setVehicle(vehicle);
}
public WorkSchedule(String jobRef, String client, String depotLocation, Driver driver, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
	
	this.jobRef = jobRef;
	this.client = client;
	this.depotLocation = depotLocation;
	this.startDate = startDate;
	this.endDate = endDate;
	
	setDriver(driver);
}

public WorkSchedule(String jobRef,  String depotLocation, int driverID, String vehicleReg, LocalDateTime startDate) throws Exception {
	
	this.jobRef = jobRef;
	this.depotLocation = depotLocation;
	this.driverID = driverID;
	this.vehicleReg = vehicleReg;
	this.startDate = startDate;
	
	
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

//toString method outputting each value seperated via space
public String toString(){
	return this.getClass().getSimpleName() + " >> " +
			jobRef + " " +
			depotLocation + " " +
			driverID + " " +
			vehicleReg + " " +
			client.toString()+" " +
			startDate.format(DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
}
public String getRegNo() {
	return vehicleReg;
	
}
public String getDepotName() {
	return depotLocation;
}

public int getDriverID() {
	return driverID;
	
}

//private static void getDepots() {
//	System.out.println("Here are a list of the Depots within the eDepot System : \n");
//for(Depot depot : depots) {
//	System.out.println(depot.getLocation());
//}
//
//}

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
