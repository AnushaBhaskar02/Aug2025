package com.cg.eis.bean;
//This is the Employee class of Lab_4_5
public class Employee4_5 {
	private int id;
	private String name;
	private double salary;
	private String designation;
	private String insuranceScheme;

	public Employee4_5(int id, String name, double salary, String designation, String insuranceScheme) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	public String getInsuranceScheme() {
		return insuranceScheme;
	}

	@Override
	public String toString() {
		return "Employee ID: " + id + ", Name: " + name + ", Salary: " + salary +
				", Designation: " + designation + ", Insurance Scheme: " + insuranceScheme;
	}
}
