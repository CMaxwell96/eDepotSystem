package eDepotSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	
	 //private Driver[] arrayAccounts;
	

	
	protected String userName;
	protected String PassWord;
	protected String Role;

	
	Driver loggedInUser = null;

	public Driver(String Username, String PassWord, String Role) { // driver object 
		this.userName = Username;
		this.PassWord = PassWord;
		this.Role = Role;
	}
	
	
	
	public boolean CheckPassword(String userLogin, String Password) {
		
		return false;
		
	
		 
	
		
		
		
	}

	public boolean IsAvilable() {
		return false;
		
	}
	
	public void SetSchedule() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassWord() {
		return PassWord;
	}
	
	public String getRole() {
		return Role;
	}



	
	
	
	
}
