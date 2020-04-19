package eDepotSystem;


public class Manager extends Driver{

	 public Manager(int driverID, String userName, String password) {
		super(driverID, userName, password);
		
	}

	
		public String toString(){
			return this.getClass().getSimpleName() + " >> " +
					
					driverID + " " +
					userName + " " +
					password;
		}

	

}
