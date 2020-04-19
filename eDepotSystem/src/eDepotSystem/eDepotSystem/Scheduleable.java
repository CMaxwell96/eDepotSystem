package eDepotSystem;


import java.time.LocalDateTime;
import java.util.List;

public interface Scheduleable {
	public Boolean isAvailable(LocalDateTime startDate, LocalDateTime endDate);
	public void addSchedule(WorkSchedule jobs);
	public List<WorkSchedule> getSchedule();
	
	
}
