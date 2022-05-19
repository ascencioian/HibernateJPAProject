package jpa.mainrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//class imports 
import jpa.entitymodels.Student;

public class SMSRunner {
	
	public static Scanner reader = new Scanner(System.in);
	
	/*test zone
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer choice = 0;
		while (choice != 2) {
			menu();
			choice = reader.nextInt();
			switch (choice) {
			case 1: //login
				Student student = new Student();
				reader.nextLine();
				System.out.print("\nEnter Your Email:\n");
				Student.setItemName(reader.nextLine());
				System.out.print("\nEnter a description for the item:\n");
				item.setItemDesc(reader.nextLine());
				System.out.print("\nEnter the item's price:\n");
				item.setItemPrice(reader.nextDouble());
				System.out.print("\nEnter the quantity available in the System:\n");
				item.setAvailableQuantity(reader.nextInt());
				System.out.println(item.getItemName());
				if (app.add(item)) {
					System.out.println("Item successfully added");
				} else {
					System.out.println("Try Again");
				}
				break;
			case 2: //add an item to the cart
				app.display();
				System.out.println("Enter the name of the item");
				reader.nextLine();
				String item_name = reader.nextLine();
				Item item1 = app.getItemCollection().get(item_name);		
				if(app.checkAvailability(item1))
				if (cart.add(item1)) {
					app.reduceAvailableQuantity(item_name);
					System.out.println("Item successfully added");
				} else {
					System.out.println("Invalid or Unavailable Item, Please Try Again");
				}
				;
				break;
			case 3: //display the cart and total summary
				cart.display();
				break;
			case 4: //display the system inventory
				app.display();
				break;
			case 5: //delete from the cart inventory
				cart.display();
				System.out.println("Enter the name of the item");
				reader.nextLine();
				item_name = reader.nextLine();
				if (cart.remove(item_name) != null) {
					System.out.println(item_name + " was removed from the cart");
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}
				break;
			case 6: //delete an item from the system inventory
				app.display();
				System.out.println("Enter the name of the item");
				reader.nextLine();
				item_name = reader.nextLine();
				if (app.remove(item_name) != null) {

					System.out.println(item_name + " was removed from the System");
					if (cart.remove(item_name) != null) {
						System.out.println(item_name + " was also removed from the cart");
					}
				} else {
					System.out.println("Invalid Item, Please Try Again");
				}

				break;
			case 7:
				System.out.println("\nByyyeee!!");
				break;
			}
		}
		reader.close();
	}
	}
	
	//display menu
	public static void menu() {
		System.out.println("Are you a(n)");
		System.out.println("1. Student");
		System.out.println("2. quit");
		System.out.println("Please enter 1 or 2.");
	}

}
