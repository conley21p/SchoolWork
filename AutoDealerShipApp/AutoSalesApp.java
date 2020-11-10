/*
* File name: AutoSalesApp.java
*
* Programmer: Conley Price
* ULID: cjpric2
*
* Date: Sep 27, 2019
*
* Class: IT 168
* Lecture Section: 07
* Lecture Instructor: Xing Fang 
* Lab Section: 08
* Lab Instructor: Tejas Chowdary Mandalapu 
*/
package edu.ilstu;

import java.util.Scanner;

/**
* <This driver class will be used to control the user interactions, which
*  include displaying the welcome message, displaying the vehicle inventory, 
*  prompting the prospective customer to select 
* a vehicle from inventory, displaying the service offerings and prompting 
* the prospective customer to select them, and finally displaying a sales receipt.>
*
* @ConleyJoesphPrice
*
*/
public class AutoSalesApp
{
	//create instance variables 
	private static String carDescrip;
	private static double price;

	
	/*create a method that creates 3 auto objects then 
	ask the user to chose which vehicle they want and 
	then assign the vehicle information to the instance variables
	 */
	private static void selectVehicle() {
		
		Auto one = new Auto(2015, "Toyota",  "Camary");
			one.setMileage(34000);
			one.setPrice(17998);
		Auto two = new Auto(2016, "Ford",  "F-150");
			two.setMileage(27000);
			two.setPrice(34600);
		Auto three = new Auto(2018, "Chevy",  "Equinox");
			three.setMileage(17000);
			three.setPrice(22498);
		
		System.out.println("Welcome to Amazing Autos!"
				+ "\n\nLet us help you find your next automobile."
				+ "\n\nCOOSE FROM OUR PROLIFIC VEHICLE INVENTORY ..."
				+ "\n-------------------------------------------------------");
		System.out.printf("%-8s%-25s%-9s%12s\n","Item#", "Vehicle", "Miles", "Price");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-8s%-25s%-,11.0f$%,5.2f\n", "1", one.toString(), one.getMileage(), one.getPrice());  
		System.out.printf("%-8s%-25s%-,11.0f$%,5.2f\n", "2", two.toString(), two.getMileage(), two.getPrice());
		System.out.printf("%-8s%-25s%-,11.0f$%,5.2f\n", "3", three.toString(), three.getMileage(), two.getPrice());
		
		System.out.print("\nSelect your vehicle by item # (e.g. 1, 2, 3): ");
		Scanner scan = new Scanner(System.in);
		String car = scan.nextLine();
		switch (car) {
		case "1":
			System.out.println("\n\nYou've selected the " + one.toString() + " ... a wise choice!");
			price = one.getPrice();
			carDescrip = one.toString();
				break;
		case "2":
			System.out.println("\n\nYou've selected the " + two.toString() + " ... a wise choice!");
			price = two.getPrice();
			carDescrip = two.toString();
				break;
		case "3":
			System.out.println("\n\nYou've selected the " + three.toString() + " ... a wise choice!");
			price = three.getPrice();
			carDescrip = three.toString();
				break;
		default : System.out.println("Invalid entry :(");
		break;
		
		
		}
	}
	
	
	//create method for selectinf the service options and displaying the receipt
	private static void seletServiceOptions() {
		
		Scanner scan = new Scanner(System.in);
		//create object from the auto sales order class and use a overloaded constructor to give vehicle description and the price
		AutoSalesOrder car = new AutoSalesOrder(carDescrip, price);
		car.setVehiclePrice();
		
		//prompt user to select what packages they want
		System.out.println("\n\nProtect your purchase with our pre-paid service offerings."
						+"\nTodays purchase qualifies for " + car.getServiceCash() + " in Service Cash." );
		System.out.print("\nAdd our 3-year oil change package for $" + car.OIL_CHANGE_PAC + " (Y or N)? ");
		car.setOilPacIndicator(scan.nextLine());
		System.out.print("\nAdd our 3-year tire rotation package for $" + car.TIRE_ROTATION_PAC + "0 (Y or N)? ");
		car.setTirePacIndicator(scan.nextLine());
		System.out.print("\nAdd our 3-year car wash package for $" + car.CAR_WASH_PAC + " (Y or N)? ");
		car.setWashPacIndicator(scan.nextLine());
		
		System.out.println("\nCongratulartions on your purchases!\n");
		
		//display receipt
		System.out.println(car.toString());
	}
	
	public static void main(String[] args)
	{
		selectVehicle();
		
		seletServiceOptions();
		
		
		
		
		
		
		
		
		
		

	}

}
