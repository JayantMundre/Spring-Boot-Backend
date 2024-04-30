package com.codewithjay.blog.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Employee {

@Id
//@GeneratedValue(strategy= GenerationType.AUTO)
private int id; //(mappedBy = "employee")
 @OneToOne(cascade = CascadeType.ALL) 
private Country country;
private String name;
private String status;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, Country country, String name, String status) {
	super();
	this.id = id;
	this.country = country;
	this.name = name;
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", country=" + country + ", name=" + name + ", status=" + status + "]";
}


}