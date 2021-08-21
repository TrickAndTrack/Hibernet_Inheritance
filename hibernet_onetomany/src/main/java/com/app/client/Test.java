package com.app.client;

import java.util.Scanner;

import com.app.Service.CoustmerFoodService;
import com.app.Service.CoustmerFoodServideImpl;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CoustmerFoodService CSS = new CoustmerFoodServideImpl();

		while (true) {
			System.out.println("1) Add Coustmer");
			System.out.println("2) Update Coustmer");
			System.out.println("3) Delete Coustmer");
			System.out.println("4) Display Coustmer");
			System.out.println("5) Save Food with Coustmer");
			System.out.println("6) Update Food");
			System.out.println("7) Delete Food");
			System.out.println("8) Display Food");
			System.out.println("9) Exit");

			System.out.println("Select any one Option");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				CSS.saveCoustmer();

				break;
			case 2:
				CSS.updateCoustmer();
				break;
			case 3:
				CSS.deleteCoustmer();
				break;
			case 4:
				CSS.displayCoustmer();
				break;
			case 5:
				CSS.saveFoodwithCoustmer();
				break;
			case 6:
				CSS.updateFood();
				break;
			case 7:
				CSS.deleteFood();
				break;
			case 8:
				CSS.displayFood();
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
