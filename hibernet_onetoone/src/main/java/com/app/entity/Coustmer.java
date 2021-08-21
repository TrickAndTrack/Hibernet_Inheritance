package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Table
@Entity
public class Coustmer {
	@Id
	@GeneratedValue(generator="gen")
	// coustmise ahe 
	// frogine key madhun alel gen  person maadhun ch id passport chy id sobt coonection sathi
	
	@GenericGenerator(name = "gen", strategy = "foreign", parameters=@Parameter(name="property",value="person"))
	//for single             parameters ni person madhe jaun id  auto krun deto  
	//@GenericGenerators()
	//for multipal
	private int id;
	
	@Column(name="passport_no")
	private String passport_no;
	@Column(name="passport_Country")
	private String passport_Country;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;
 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}



	public String getPassport_Country() {
		return passport_Country;
	}
	public void setPassport_Country(String passport_Country) {
		this.passport_Country = passport_Country;
	}



	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}



	@Override
	public String toString() {
		return  id +"\t" +"\t"+ passport_no+"\t"+"\t" + passport_Country ;
	}
	
	
	
	
	
}
