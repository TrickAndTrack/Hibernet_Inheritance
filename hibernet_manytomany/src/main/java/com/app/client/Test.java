package com.app.client;

import java.util.Scanner;

import com.app.Service.DepartmentFacultyService;
import com.app.Service.DepartmentFacultyServideImpl;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DepartmentFacultyService CSS = new DepartmentFacultyServideImpl();

		while (true) {
			System.out.println("1) Add department");
			System.out.println("2) Update department");
			System.out.println("3) Delete department");
			System.out.println("4) Display department");
			System.out.println("5) Save faculty");
			System.out.println("6) Update faculty");
			System.out.println("7) Delete faculty");
			System.out.println("8) Display faculty");
			System.out.println("9) Exit");

			System.out.println("Select any one Option");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				CSS.saveDepratment();

				break;
			case 2:
				CSS.updateDepratment();
				break;
			case 3:
				CSS.deleteDepratment();
				break;
			case 4:
				CSS.displayDepratment();
				break;
			case 5:
				CSS.savefaculty();
				break;
			case 6:
				CSS.updatefaculty();
				break;
			case 7:
				CSS.deletefaculty();
				break;
			case 8:
				CSS.displayfaculty();
				break;
			case 9:
				System.out.println("Yor are Exit");
				System.exit(0);
				break;

			default:
				System.out.println("You Enter Wrong Input Try Letter");
				break;
			}
		}

	}

}
