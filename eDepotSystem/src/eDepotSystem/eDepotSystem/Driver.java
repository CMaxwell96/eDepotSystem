package eDepotSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Driver implements Scheduleable {
	
	private static List<Driver> drivers = new ArrayList<Driver>();
	private static List<WorkSchedule> jobs = new ArrayList<WorkSchedule>();

	public  int driverID;
	public  String userName;
	public String password;
	protected Boolean update = false;
	
	
	public Driver(int driverID, String userName, String password) {
		this.driverID = driverID;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addDriver(Driver driver) {
		//validate?
		
		drivers.add(driver);
			
	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static Driver getDriverByID(int driverID) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(driverID)){
				return d;
				
			}
			}
		//if no match
		return null;
	}
	public WorkSchedule makeJob(WorkSchedule jobDateTime) {
		jobs.add(jobDateTime);
		
	

			
		//if no match
		return null;
}

	public WorkSchedule getNextJob() {
		
		jobs.sort(Comparator.comparing(o -> o.getStartDate()));
		
		return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
		
	}


	@Override
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

	@Override
	public void addSchedule(WorkSchedule jobs) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<WorkSchedule> getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

}
