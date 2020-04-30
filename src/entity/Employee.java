package entity;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056663232073769636L;
	
	private String firstName,lastName,mail,workerID,organizationalAffiliation;
	private Jobs workerJob;
	
	public Employee(String workerID,String firstName, String lastName, String mail, Jobs workerJob,String organizationalAffiliation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.workerID = workerID;
		this.workerJob = workerJob;
		this.organizationalAffiliation=organizationalAffiliation;
	}
	
	public String getOrganizationalAffiliation() {
		return organizationalAffiliation;
	}

	public void setOrganizationalAffiliation(String organizationalAffiliation) {
		this.organizationalAffiliation = organizationalAffiliation;
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
				+ workerID + ", organizationalAffiliation=" + organizationalAffiliation + ", workerJob=" + workerJob
				+ "]";
	}

}
