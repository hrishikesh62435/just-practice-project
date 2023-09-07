package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_employee") 
public class Employee {

  
	public Employee() {  
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String password;
	private String userRole;
	private String readPassword;
	private String employeeName;
	private String employeeAddress;
	private double employeeSalary;
	private String employeeEmail;    
	
	
	
	
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getPassword() {
		return password;
	}
	public String getUserRole() {
		return userRole;
	}
	public String getReadPassword() {
		return readPassword;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeAddress() {  
		return employeeAddress;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public void setReadPassword(String readPassword) {
		this.readPassword = readPassword;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	public Employee(int employeeId, String username, String password, String userRole, String readPassword,
			String employeeName, String employeeAddress, double employeeSalary, String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.userRole = userRole;
		this.readPassword = readPassword;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
		this.employeeEmail=employeeEmail;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", username=" +  ", password=" + password
				+ ", userRole=" + userRole + ", readPassword=" + readPassword + ", employeeName=" + employeeName
				+ ", employeeAddress=" + employeeAddress + ", employeeSalary=" + employeeSalary + employeeEmail + "]";
	}
	
	
	

}
