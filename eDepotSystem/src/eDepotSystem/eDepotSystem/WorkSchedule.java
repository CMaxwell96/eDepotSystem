package eDepotSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eDepotSystem.Vehicle;
import eDepotSystem.Driver;

public class WorkSchedule {
	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();

private String jobRef;
private String client;
private LocalDateTime startDate;
private Date endDate;

public WorkSchedule(String ref, String depotName, String driverID, String vehicleReg, LocalDateTime jobStartDate) {
	// TODO Auto-generated constructor stub
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
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String toString(){
	return this.getClass().getSimpleName() + " >> " +
			jobRef + " " +
			client.toString()+" " +
			startDate.format(DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
}
public String getRegNo() {
	return getRegNo();
	
}
public String getDriverID() {
	return getDriverID();
	
}
public LocalDateTime getJobStartDate(){
	return startDate;
}

public String getJobRef() {
	return jobRef;
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
