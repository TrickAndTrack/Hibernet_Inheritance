package com.app.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table
public class Department {

	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name= "department_name")
	private String departmentname;
	
	@ManyToMany
	@JoinTable(name="department_faculty",
	           joinColumns=@JoinColumn(name="depart_id"),
	           inverseJoinColumns=@JoinColumn(name="facult_id"))
	private List<Faculty> Faculty;

	
	
	public List<Faculty> getFaculty() {
		return Faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.Faculty = faculty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Override
	public String toString() {
		return   id + "\t" +departmentname ;
	}
}
