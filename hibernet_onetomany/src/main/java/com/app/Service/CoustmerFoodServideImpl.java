package com.app.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Coustmer;
import com.app.entity.Foods;
 
import com.app.utility.ScannerUtility;
import com.app.utility.utility;

public class CoustmerFoodServideImpl implements CoustmerFoodService {
	Scanner sc = ScannerUtility.getScanner();

	public void saveCoustmer() {
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();
		List<Coustmer> list = new ArrayList<Coustmer>();
		System.out.println("How many Coustmer Do You want Add");
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			Coustmer Coustmer1 = new Coustmer();
			System.out.println("Enter Coustmer Name");
			Coustmer1.setCoustmername(sc.next());
			System.out.println("Enter Coustmer Mobile Number");
			Coustmer1.setMobile_no(sc.next());
			list.add(Coustmer1);

			session.save(Coustmer1);
		}

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
	}

	@SuppressWarnings("resource")
	public void updateCoustmer() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayCoustmer();
		System.out.println("Which Coustmer Do You want to update, Please enter id:");
		int cid = scanner.nextInt();
		Coustmer coustmer = (Coustmer) session.get(Coustmer.class, cid);

		System.out.println("Enter Coustmer Name");
		coustmer.setCoustmername(sc.next());
		System.out.println("Enter Coustmer Mobile Number");
		coustmer.setMobile_no(sc.next());

		session.update(coustmer);

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
	}

	@SuppressWarnings("resource")
	public void deleteCoustmer() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayCoustmer();
		System.out.println("Which Coustmer Do You want to delete, Please enter id:");
		int cid = scanner.nextInt();
		Coustmer coustmer = (Coustmer) session.get(Coustmer.class, cid);

		session.delete(coustmer);
		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Coustmer> displayCoustmer() {
		Session session = utility.getConnection().openSession();
		List<Coustmer> list = session.createCriteria(Coustmer.class).list();
		for (Coustmer c : list) {
			System.out.println(c);
			System.out.println("\t" + "\t" + c.getFood());
		}
		session.close();
		return list;
	}

	public void saveFoodwithCoustmer() {
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("How many items do you want to order");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Foods food = new Foods();
			System.out.println("Enter food Name");
			food.setFood_name(sc.next());
			System.out.println("Enter Food Price");
			food.setFood_price(sc.nextInt());

			System.out.println("Coustmer allocate to food");
			int cid = sc.nextInt();
			Coustmer coustmer = (Coustmer) session.get(Coustmer.class, cid);
			if (null != coustmer) {
				food.setCoustmer(coustmer);
			}
			session.save(food);

			tx.commit();
			session.close();
			if (tx.wasCommitted()) {
				System.out.println("saved");
			} else {
				System.out.println("failed");
			}
		}
	}

	@SuppressWarnings("resource")
	public void updateFood() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayFood();
		System.out.println("Which Food Do You want to update, Please enter id:");
		int id = scanner.nextInt();
		Foods food = (Foods) session.get(Foods.class, id);

		System.out.println("Enter food Name");
		food.setFood_name(sc.next());
		System.out.println("Enter Food Price");
		food.setFood_price(sc.nextInt());

		session.update(food);

		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
	}

	@SuppressWarnings("resource")
	public void deleteFood() {
		Scanner scanner = new Scanner(System.in);
		Session session = utility.getConnection().openSession();
		Transaction tx = session.beginTransaction();

		displayFood();
		System.out.println("Which food Do You want to delete, Please enter id:");
		int id = scanner.nextInt();
		Foods food = (Foods) session.get(Foods.class, id);
		session.delete(food);
		tx.commit();
		if (tx.wasCommitted()) {
			System.out.println("saved");
		} else {
			System.out.println("failed");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Foods> displayFood() {
		Session session = utility.getConnection().openSession();
		List<Foods> Flist = session.createCriteria(Foods.class).list();
		for (Foods f : Flist) {
			System.out.println(f);
			System.out.println("\t" + "\t" + f.getCoustmer());
		}
		session.close();
		return Flist;
	}

	

}
