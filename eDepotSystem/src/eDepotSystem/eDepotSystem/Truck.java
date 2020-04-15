package eDepotSystem;

public class Truck extends Vehicle{
	private int cargoCapacity;

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public Truck(String make, String model, int weight, String RegNo, int cargoCapacity) {
		super(make, model, weight, RegNo);
		// TODO Auto-generated constructor stub
	}
	
	

	public String toString() {
        return  "Truck Make:" +this.make + " Truck Model:" + this.model + " Truck RegNo:" + this.RegNo + " cargo:" + this.cargoCapacity;
}
}
