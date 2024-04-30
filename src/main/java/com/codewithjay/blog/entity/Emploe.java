package com.codewithjay.blog.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
  @Entity
public class Emploe {
	@Id
     private int id; //(mappedBy = "employee")
	 @OneToOne(cascade = CascadeType.ALL) 
	private Country country;
	private String name;
	private String phone;
	private String department;
	private Date crdt;
	private String createdby;
	private String status;
	public Emploe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emploe(int id, Country country, String name, String phone, String department, Date crdt, String createdby,
			String status) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
		this.phone = phone;
		this.department = department;
		this.crdt = crdt;
		this.createdby = createdby;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getCrdt() {
		return crdt;
	}
	public void setCrdt(Date crdt) {
		this.crdt = crdt;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Emploe [id=" + id + ", country=" + country + ", name=" + name + ", phone=" + phone + ", department="
				+ department + ", crdt=" + crdt + ", createdby=" + createdby + ", status=" + status + "]";
	}

}