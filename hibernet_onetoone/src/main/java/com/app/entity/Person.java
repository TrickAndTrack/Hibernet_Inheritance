package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	private String name;
	private int Adhar_no;
	
	// id je ahe te match krte passport sobtch id

	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	//                   ^ he name passort madhe private madhl name ahe
	// person ch adhar ani adhar ch person mhnu he apn attch kel
	private Coustmer passport;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAadhar_no() {
		return Adhar_no;
	}

	public void setAadhar_no(int aadhar_no) {
		this.Adhar_no = aadhar_no;
	}

	public Coustmer getPassport() {
		return passport;
	}

	public void setPassport(Coustmer passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return  id+"\t" +  name+"\t" + Adhar_no ;
	}
}
