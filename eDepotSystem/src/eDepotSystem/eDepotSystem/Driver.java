package eDepotSystem;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	private static List<Driver> drivers = new ArrayList<Driver>();

	public  String userName;
	public String password;
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
	
	public static Driver getDriverByID(String ID) {
		
		for (Driver d : drivers) {
			if (d.getName().equals(ID)){
				return d;
				
			}
			}
		//if no match
		return null;
	}

}
