package eDepotSystem;

import java.util.Scanner;

public class eDepotSystem {
	static Scanner scan = new Scanner(System.in);
	static int inputNumber;
	

	public static void main(String[] args) {
		
		displayMenu();

	}
	
	private static void displayMenu() {
		
		while(true){
			System.out.println("Welcome to the eDepotSystem\n");
			System.out.println("Below you will find the menu which shows which services are available on the system\n");
			System.out.println("Menu:");
			System.out.println("(1) View Depots on the system");
			
			String userChoice =scan.nextLine();
			
			try {
				inputNumber = Integer.parseInt(userChoice);
			} catch (Exception e) {
				System.out.println("Please enter a number to the left of the menu options");
			}
			
			switch(inputNumber) {
				case 1: 
					displayMenu();
					break;
			}
			
			
		}
		
	}
	

}
