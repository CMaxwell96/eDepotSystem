package eDepotSystem;

import java.util.Date;

public class WorkSchedule {

private String client;
private Date startDate;
private Date endDate;

public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String toString(){
	return this.getClass().getSimpleName() + " >> " +
			client + " " +
			client.toString()+" " +
			startDate.format(DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
}
}
