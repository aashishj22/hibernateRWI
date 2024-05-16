package org.example.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "EmployeeRecord")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Id")
    private int empId;

    @Column(name = "Name")
    private String name;

    @Column(name = "City")
    private String city;

    @Lob
    @Column(name = "Image", columnDefinition = "LONGBLOB")
    private byte[] image;

    // Constructors, getters, and setters

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Employee(int empId, String name, String city, byte[] image) {
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.image = image;
    }
}
