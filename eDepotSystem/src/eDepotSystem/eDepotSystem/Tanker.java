 package eDepotSystem;

public class Tanker extends Vehicle{
	public enum liquidType{
		OIL, CHEMICAL;
	}
	public Tanker(String make, String model, int weight, String RegNo, int liquidCapacity, String liquidType) {
		super(make, model, weight, RegNo);
		// TODO Auto-generated constructor stub
	}
	
	public  int liquidCapacity;
	public String liquidType;
	
	public int getLiquidCapacity() {
		return liquidCapacity;
	}
	public void setLiquidCapacity(int liquidCapacity) {
		this.liquidCapacity = liquidCapacity;
	}
	public String getLiquidType() {
		return liquidType;
	}
	public void setLiquidType(String liquidType) {
		this.liquidType = liquidType;
	}
	
	public String toString() {
        return  "Tanker Make:" +this.make + " Tanker Model:" + this.model + " Tanker RegNo:" + this.RegNo;
    }

}
