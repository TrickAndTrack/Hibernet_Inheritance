package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Coustmer {

	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name= "coustmer_name")
	private String coustmername;
	@Column(name="coustmer_mob_no")
	private String mobile_no;
	@OneToMany(mappedBy="coustmer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Foods> food;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoustmername() {
		return coustmername;
	}

	public void setCoustmername(String coustmername) {
		this.coustmername = coustmername;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public List<Foods> getFood() {
		return food;
	}

	public void setFood(List<Foods> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return   id + "\t" +coustmername + "\t" + mobile_no ;
	}
}
