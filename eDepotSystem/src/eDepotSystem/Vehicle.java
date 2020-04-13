package eDepotSystem;

public class Vehicle {
	
	//instance fields
	
	public String make;
	public String model;
	public int weight;
	public String RegNo;
	public static boolean IsAvailable;
	
	protected List<Job> jobs = new ArrayList<Job>();
	
	public Vehicle (String make,String model, int weight, String RegNo) {
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.RegNo = RegNo;
	
	}
	
	public String getMake() {
		return make;
		
	}
	
	public String getModel() {
		return model;
		
	}
	
	public int getWeight() {
		return weight;
		
	}
	
	public String getRegNo() {
		return RegNo;
		
	}
	
	public void makeJob(Job jobDateTime) {
		jobs.add(jobDateTime);
		
	}
	
	public Job getNextJob() {
		
		jobs.sort(Comparator.comparing(o -> o.getStartDate()));
		
		return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
		
	}

	

}
