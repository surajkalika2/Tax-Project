package com.learning.j10.model;

public class Clients {

	private int clientID;
	private String firstName;
	private String lastName;
	private double currentSalary;
	private String status;
	@Override
	public String toString() {
		return "Clients [clientID=" + clientID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", currentSalary=" + currentSalary + ", status=" + status + "]";
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public Clients() {
	}
	public Clients(int clientsID, String firstName, String lastName, double currentSalary, String status) {
		super();
		this.clientID = clientsID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentSalary = currentSalary;
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getCurrentSalary() {
		return currentSalary;
	}
	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
