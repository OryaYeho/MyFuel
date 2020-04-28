package entity;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056663232073769636L;
	
	private String firstName,lastName,mail,workerID;
	private Jobs workerJob;
	
	public Employee(String workerID,String firstName, String lastName, String mail, Jobs workerJob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.workerID = workerID;
		this.workerJob = workerJob;
	}
	
	public void setWorkerJob(Jobs workerJob) {
		this.workerJob = workerJob;
	}

	public Jobs getWorkerJob() {
		return workerJob;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMail() {
		return mail;
	}

	public String getWorkerID() {
		return workerID;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", workerID="
				+ workerID + ", workerJob=" + workerJob + "]";
	}
	
	
	
}
