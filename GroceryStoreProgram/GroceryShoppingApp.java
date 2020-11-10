/*
* File name: GroceryShoppingApp.java
*
* Programmer: Conley Price
* ULID: cjpric2
*
* Date: Sep 23, 2019
*
* Class: IT 168
* Lecture Section: 07
* Lecture Instructor: Xing Fang 
* Lab Section: 08
* Lab Instructor: Tejas Chowdary Mandalapu 
*/
package edu.ilstu;

/**
* <This program will display a shopping menu
* and calculate the price of the users products they select>
*
* @ConleyJoesphPrice
*
*/
import java.util.Scanner;

public class GroceryShoppingApp {


	public static void main(String[] args) {

		
			//Table one
			System.out.printf("%-20sPrice Per Pound\n", "Vegetables Name");
			System.out.printf("%-20s$3.12\n", "Broccoli");
			System.out.printf("%-20s$1.15\n", "Yellow Onion");
			System.out.printf("%-20s$4.58\n", "Chili Pepper");
			System.out.printf("%-20s$2.82\n", "Greens Bundle");
			System.out.println("------------------------------------");
		
			//Prompt user input to get values
			System.out.println("Table 1 : Vegetable names with corresponding price per pound\n");
		
			System.out.print("Please select the vegetable from Table 1: ");
				Scanner scan = new Scanner(System.in);
				String vegetableName = scan.nextLine();
				System.out.print("Please enter the price of the selected vegetable: ");
				double vegetablePrice = scan.nextDouble();
			System.out.println("\n------------------------------------");
		
		
			//display table 2
			System.out.printf("%-20sPrice Per Pound\n", "Fruit Name");
			System.out.printf("%-20s$1.73\n", "Apple");
			System.out.printf("%-20s$2.15\n", "Grape");
			System.out.printf("%-20s$2.58\n", "Key Lime");
			System.out.printf("%-20s$1.86\n", "Navel Orange");
			System.out.println("------------------------------------");
		
			//Prompt user input to get values
			System.out.println("Table 2 : Fruit names with corresponding price per pound\n");
			System.out.print("Please select the Fruit from Table 2: ");
				Scanner scan1 = new Scanner(System.in);
				String fruitName = scan1.nextLine();
			System.out.print("Please enter the price of the selected fruit: ");
				double fruitPrice = scan1.nextDouble();
			System.out.println("\n------------------------------------");
			
			//creating object and giving values
			Products item1 = new Products(vegetableName, vegetablePrice, fruitName, fruitPrice);
			
	
			//Grocery Store Shopping Menu
			System.out.println("Grocery Shopping Menu\n");
			System.out.printf("%-20sPrice Per Pound\n", "Name:");
			System.out.printf("%-20s%.2f\n", item1.getVegetableName() , item1.getPricePerPoundVetgetable());
			System.out.printf("%-20s%.2f\n------------------------------------\n\n", item1.getFruitName() , item1.getPricePerPoundFruit());
			System.out.print("Enter the pounds of " + item1.getVegetableName() + " ordered: ");
			item1.setVegetablesOrdered(scan1.nextDouble());
			System.out.print("Enter the pounds of " + item1.getFruitName() + " ordered: ");
			item1.setFruitsOrdered(scan1.nextDouble());
			System.out.println("\n\n-------------------------------------");
	
	
			//Grocery Store Summary
			item1.displayOrderSummary();
	
	}

}