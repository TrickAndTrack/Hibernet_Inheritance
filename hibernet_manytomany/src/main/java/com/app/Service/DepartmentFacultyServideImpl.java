package com.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Department;
import com.app.entity.Faculty;

import com.app.utility.ScannerUtility;
import com.app.utility.utility;

public class DepartmentFacultyServideImpl implements DepartmentFacultyService {
	Scanner sc = ScannerUtility.getScanner();
	
	
	@SuppressWarnings("unchecked")
	public List<Department> displayDepratment() {
		Session session = utility.getConnection().openSession();
		List<Department> list = session.createCriteria(Department.class).list();
		for (Department department : list) {
			System.out.println(department.getId() + " \t " + department.getDepartmentname());
		}
		session.close();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Faculty> displayfaculty() {
		Session session = utility.getConnection().openSession();
		List<Faculty> list = session.createCriteria(Faculty.class).list();
		for (Faculty facultys : list) {
			System.out.println(facultys.getId() + " \t " + facultys.getFacultyname());
		}
		session.close();
		return list;
	}
	
	public void saveDepratment() {
		//List<Department> list = new ArrayList<Department>();
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("How many Depratment Do You want Add");
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			Department Department = new Department();
			System.out.println("Enter Depratment Name");
			Department.setDepartmentname(sc.next());
			
			session.save(Department);
		}

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		session.close();
	}

	@SuppressWarnings("resource")
	public void updateDepratment() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayDepratment();
		System.out.println("Which Depratment Do You want to update, Please enter id:");
		int did = scanner.nextInt();
		Department Depratment = (Department) session.get(Department.class, did);

		System.out.println("Enter Depratment Name");
		Depratment.setDepartmentname(sc.next());
		

		session.update(Depratment);

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		session.close();
	}

	@SuppressWarnings("resource")
	public void deleteDepratment() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayDepratment();
		System.out.println("Which Depratment Do You want to delete, Please enter id:");
		int did = scanner.nextInt();
		Department coustmer = (Department) session.get(Department.class, did);

		session.delete(coustmer);
		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		session.close();
	}



	@SuppressWarnings("resource")
	public void updatefaculty() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayfaculty();
		System.out.println("Which faculty Do You want to update, Please enter id:");
		int id = scanner.nextInt();
		Faculty faculty = (Faculty) session.get(Faculty.class, id);

		System.out.println("Enter faculty Name");
		faculty.setFacultyname(sc.next());

		session.update(faculty);

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		session.close();
	}

	@SuppressWarnings("resource")
	public void deletefaculty() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayfaculty();
		System.out.println("Which faculty Do You want to delete, Please enter id:");
		int id = scanner.nextInt();
		Faculty faculty = (Faculty) session.get(Faculty.class, id);
		session.delete(faculty);
		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		session.close();
	}

	

	public void savefaculty() {
		List<Faculty> facultyList = new ArrayList<Faculty>();
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("How many faculty Do You want Add");
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			List<Department> dlist = new ArrayList<Department>();

			Faculty f = new Faculty();
			System.out.println("Enter faculty Name");
			f.setFacultyname(sc.next());

			System.out.println("How many department allocate");
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				displayDepratment();
				System.out.println("Department allocate to faculty");
				int did = sc.nextInt();
			
				Department Department = (Department) session.get(Department.class, did);
				dlist.add(Department);
			}

			f.setDepartment(dlist);
			session.save(f);
		}
		tx.commit();
		session.close();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else 
			System.out.println("failed");
	}

}
