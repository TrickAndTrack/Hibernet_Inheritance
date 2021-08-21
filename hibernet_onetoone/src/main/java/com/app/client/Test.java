package com.app.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.app.entity.Person;
import com.app.entity.Coustmer;
import com.app.utility.utility;

public class Test {
	
	public void savePersonAndPassport() {
		Person person= new Person();
		person.setName("rojar");
		person.setAadhar_no(349488342);
		
		Coustmer ppt=new Coustmer();
		ppt.setPassport_no("US23456");
		ppt.setPassport_Country("USA");
		
		ppt.setPerson(person);
		person.setPassport(ppt);
		// ppt la person ani person la passport  atch kel bidirection perform kel
		
		Session session =utility.getConnection().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(person);
		tx.commit();
		
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		
	}
	public void selectAll() {
		Session session =utility.getConnection().openSession();
		List <Person> list=session.createCriteria(Person.class).list();
		for (Person person : list) {
			System.out.println(person);
			System.out.println("\t"+person.getPassport());
		}	
	} 
	public void updatePersonAndPassport() {
		Session session = utility.getConnection().openSession();
		Person person = (Person) session.get(Person.class, 2);

		person.setName("Pranjal");
		person.setAadhar_no(782555383);
		person.getPassport().setPassport_no("KK34455");
		person.getPassport().setPassport_Country("Koria");

		Transaction tx = session.beginTransaction();

		session.update(person);
		tx.commit();

		if (tx.wasCommitted())
			System.out.println("updated");
		else
			System.out.println("failed");

		
	}
	public void deletePersonAndPassport() {
		Session session =utility.getConnection().openSession();
		Person person =(Person) session.get(Person.class, 8);
		
		Transaction tx=session.beginTransaction();
		
		
		session.delete(person);
		tx.commit();
		
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
		
		}
	
	
public static void main(String[] args) {
	Test t= new Test();
	t.savePersonAndPassport();

	//t.deletePersonAndPassport();
	
	//t.updatePersonAndPassport();
	t.selectAll();
	
}
}
