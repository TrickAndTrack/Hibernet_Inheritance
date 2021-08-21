 package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
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

public class Faculty {
	
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name= "faculty_name")
	private String facultyname;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="department_faculty",
			joinColumns=@JoinColumn(name="facult_id"),
					inverseJoinColumns=@JoinColumn(name="depart_id"))
	private List<Department> Department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public List<Department> getDepartment() {
		return Department;
	}

	public void setDepartment(List<Department> department) {
		Department = department;
	}

	@Override
	public String toString() {
		return  id + "\t" + facultyname ;
	} 
	
	

	
	
	

	
	
	

}
