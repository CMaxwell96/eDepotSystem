package eDepotSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class eDepotSystem {
	private static   WorkSchedule Schedule;
	
	public static void main(String[] args) {
		
		
		
		new Depot(); // run system 
		
		
	}
	
	// Manager Menu contaisn manager options such as create schedule 
	public static void ManagerMenu() {
		
		System.out.println("\nWelocome to the manager Menu system\n");
		
		System.out.println("Please select what option you would want from the Menu below by typing the number to the left of it\n");
		System.out.println("(1) Display work Schedule");
		System.out.println("(2) Setup work Schedule");
		System.out.println("(3) Move Vehicle");
		System.out.println("(Q) Quit");
		
		 String choice = null;
	        Scanner scan = new Scanner(System.in);
	        do {
	            choice = scan.nextLine();
	            switch (choice) {
	            case "1":
	            viewSchedule();
	            	
	      
	            } 
	        } while (!choice.equals("Q")); // end of loop
		
		
		
		
		
	}
	// regular driver menu presents options such as view schedule 
	public static void DriverMenu() {
		
		
		System.out.println("\nWelocome to the Driver Menu system\n");
		
		System.out.println("Please select what option you would want from the Menu below by typing the number to the left of it\n");
		System.out.println("(1) Display work Schedule");
		
		
		
		
		 String choice = null;
	        Scanner scan = new Scanner(System.in);
	        do {
	            choice = scan.nextLine();
	            switch (choice) {
	            case "1":
	            viewSchedule();
	            	
	      
	            } 
	        } while (!choice.equals("Q")); // end of loop
		
		
	}
	// shows work schedule all jobs 
	public static void viewSchedule() {
		Scanner s = new Scanner(System.in);
		
		String csvFile = "Schedule.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<WorkSchedule> listOfUsers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] workschedule = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + sysusers[1] + " , name=" + sysusers[2] + "Role" + sysusers[3]);
                listOfUsers.add(new WorkSchedule(workschedule[0],workschedule[1],workschedule[2]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WorkSchedule user : listOfUsers){
        	System.out.println("Client: " + user.getClient() + " Start Date: " + user.getStartDate()  + " End Date: " + user.getEndDate());
        	
        }
        
	}
	
	

	

}
