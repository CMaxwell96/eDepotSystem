package eDepotSystem;

import java.time.LocalDateTime;
import java.util.List;

public class JobCheck implements Runnable {

	private List<WorkSchedule> jobs;
	private Integer delay;
	
	public JobCheck(List<WorkSchedule> jobs, int seconds) {
		this.jobs = jobs;
		setSeconds(seconds);
	}



	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(delay);
				
				synchronized (jobs) {
					
					for (WorkSchedule job : jobs) {
						if(!job.isUpdate()) {
							if(job.getJobStartDate().minusDays(1).isBefore(LocalDateTime.now())) {
								job.setUpdate(true);
								
								System.err.print("setUpdate " + job.getJobRef() + ":)\n");
							}
						}
					}
				}
			
		}
			catch(Exception e) {
			e.printStackTrace();	
			}}
			}

	

	public static void main(String[] args) {
	}

	private synchronized void setSeconds(Integer seconds) {
		delay = seconds * 1000;	
	}
	
	public Integer getSeconds() {
		return delay / 1000;
	}
}
