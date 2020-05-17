package Entity;

public class Supplier extends User{
	
	private String fuelType;

	public Supplier(String userName, String password, String firstName, String lastName, String mail, String id,
			String phoneNumber,int online, String fuelType) {
		super(userName, password, firstName, lastName, mail, id, phoneNumber,online);
		this.fuelType = fuelType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Supplier [fuelType=" + fuelType + "]";
	}
	
}
