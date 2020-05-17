package Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Date might be changed to String

public class CustomerModule {

	private String id;
	private int modelNumber;

	private Set<String> companyNamesSubscribed = new HashSet<String>();
	private String startDate;
	private String endDate;
	
	/**
	 * 
	 * */
	public CustomerModule(String id, int modelNumber, Set<String> companyNamesSubscribed, String startDate,
			String endDate) {
		this.id = id;
		this.modelNumber = modelNumber;
		this.companyNamesSubscribed = companyNamesSubscribed;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Set<String> getCompanyNamesSubscribed() {
		return companyNamesSubscribed;
	}

	public void setCompanyNamesSubscribed(Set<String> companyNamesSubscribed) {
		this.companyNamesSubscribed = companyNamesSubscribed;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "CustomerModule [id=" + id + ", modelNumber=" + modelNumber + ", companyNamesSubscribed="
				+ companyNamesSubscribed + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
