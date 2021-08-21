package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Foods {
	
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private int id;
	
	@Column(name= "food_name")
	private String food_name;
	
	@Column(name="food_price")
	private int food_price;
	
	public int getFood_price() {
		return food_price;
	}

	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}

	@Column(name="coustmer_id", insertable=false,updatable=false)
	private int coustmer_id;
	
	@ManyToOne
	@JoinColumn(name="coustmer_id")
	private Coustmer coustmer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	
	public int getCoustmer_id() {
		return coustmer_id;
	}

	public void setCoustmer_id(int coustmer_id) {
		this.coustmer_id = coustmer_id;
	}

	public Coustmer getCoustmer() {
		return coustmer;
	}

	public void setCoustmer(Coustmer coustmer) {
		this.coustmer = coustmer;
	}

	@Override
	public String toString() {
		return  coustmer_id+ "\t"+ food_name + "\t" + food_price + "Rs";
	}
//	id+"\t" + "\t" +
	
	
	

}
