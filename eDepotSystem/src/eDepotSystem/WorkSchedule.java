package eDepotSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WorkSchedule {
	
	private String Client;
	private String startDate;
	private String EndDate;
	
	public WorkSchedule(String Client, String startDate, String EndDate) {
		this.Client = Client;
		this.startDate = startDate;
		this.EndDate = EndDate;
		
		
	}
	
	

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	}



