package eDepotSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Depot {
	
	private Driver user;
	private eDepotSystem Systems;

	

	public Depot() {
		
		System.out.println("Welcome to the eDepotSystem\n"); // Welcome message 
		
		System.out.println("Please enter your login details to gain access to the system\n");        // Message to prompt user login
		LogOn(); // Call LogOn method which contains code to verify user Login against our user File
		
	}
	
	public void LogOn(){	//Logon Method 
		
		//Declared Variables for later use 
		
		String userName = null;
		String Password = null; 
		Driver loggedInUser = null;
		Scanner s = new Scanner(System.in);
		String csvFile = "Users.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        //ArrayList to store DriverObjects 
        List<Driver> listOfUsers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Try to real file if cant throw error message 

            while ((line = br.readLine()) != null) { //Whilst file next input isnt null continue to read each line

                // use comma as separator
                String[] sysusers = line.split(cvsSplitBy); // split lines by comma and store them in string array 

               
                listOfUsers.add(new Driver(sysusers[0],sysusers[1],sysusers[2])); // Create new object then add to list of usersarray

            }
// error Handling 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// user Login prompt has message and inputs 
		 
        System.out.println("Username: ");
		userName = s.nextLine();
		System.out.println("Password: ");
		Password = s.nextLine();
		
	
		
		  for (Driver user : listOfUsers) // for the length of listofUsers array 
	        {
	            if (user.getUserName().equals(userName)) // if user input matches username on system 
	            {
	                if (user.getPassWord().equals(Password)) // if user name is match and password is match on same line 
	                {
	                    loggedInUser = user; // then that data is passed into a new Driver object called Logged in user

	                    // when a user is found, "break" stops iterating through the list
	                    break;
	                }
	            }
	        }
		  
		  
		
		  if (loggedInUser != null) //if object is not empty 
	        {
	            System.out.println("\nUser successfully logged in: "+loggedInUser.getUserName() + "\nUser Role: " + loggedInUser.getRole()); // print user name and role in company 
	            
	            
	            if(loggedInUser.getRole().equals("Manager")) { // if user role is manager present the manager menu with more options 
	            	eDepotSystem.ManagerMenu();
	            } else if(loggedInUser.getRole().equals("Driver")) { // if regular driver show them only basic options
	            	eDepotSystem.DriverMenu();
	            }
	        }
	        else
	        {
	            System.out.println("Invalid username/password combination"); // if neither present message
	            LogOn();
	        }
		
		
		
	}

	
	public Vehicle GetVehicle() {
		return null;
		
	}
	
	public Driver GetDriver() {
		return null;
		
	}
	
	public void SetupWorkScheule() {
		
	}
}



