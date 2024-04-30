package com.codewithjay.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private int cid;
private String cname;
//@OneToOne
//private Employee employee;
public Country() {
	super();
	// TODO Auto-generated constructor stub
}
public Country( String cname, int cid) {
	super();
	this.cid = cid;
	this.cname = cname;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Country [cid=" + cid + ", cname=" + cname + "]";
}
}