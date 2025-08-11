package com.cg.eis.bean;

// Lab4_3 - Employee bean with CSV helpers
public class Employee4_3 {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Employee4_3() {}

    public Employee4_3(int id, String name, double salary, String designation, String insuranceScheme) {
        this.id = id; this.name = name; this.salary = salary; this.designation = designation;
        this.insuranceScheme = insuranceScheme;
    }

    public Employee4_3(int id, String name, double salary, String designation) {
        this(id, name, salary, designation, "Not Assigned");
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getInsuranceScheme() { return insuranceScheme; }
    public void setInsuranceScheme(String insuranceScheme) { this.insuranceScheme = insuranceScheme; }

    @Override
    public String toString() {
        return "Employee [id=" + id +
               ", name=" + name +
               ", salary=" + salary +
               ", designation=" + designation +
               ", insuranceScheme=" + insuranceScheme + "]";
    }

    public String toCSV() {
        return id + "," + name.replace(",", "") + "," + salary + "," + designation.replace(",", "") + "," + insuranceScheme.replace(",", "");
    }

    public static Employee4_3 fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", 5);
        if (parts.length < 5) return null;
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        double salary = Double.parseDouble(parts[2].trim());
        String designation = parts[3].trim();
        String scheme = parts[4].trim();
        return new Employee4_3(id, name, salary, designation, scheme);
    }
}
