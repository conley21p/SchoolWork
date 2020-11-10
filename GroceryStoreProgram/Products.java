package edu.ilstu;

/*
* File name: Products.java
*
* Programmer: Conley Price
* ULID: cjpric2
*
* Date: Sep 18, 2019
*
* Class: IT 168
* Lecture Section: 07
* Lecture Instructor: Xing Fang 
* Lab Section: 08
* Lab Instructor: Tejas Chowdary Mandalapu 
*/

/**
* <This is a user defined class that will will have
 * methods to that will be used is the ShoppingApp class.
 * These methods will display different parts of the 
 * shopping menu and also compute differnet prices for the user>
*
* @ConleyJoesphPrice
*
*/

public class Products {

	//Declaring variables and constants
	private String vegetableName, fruitName;
	private double pricePerPoundVetgetable, vegetablesOrdered,  pricePerPoundFruit, fruitsOrdered;
	public static final double SERVICE_RATE = .035;
	public static final double DELIVERY_FEE = 5;
	
	
	//default constructor
	public Products() {}
	
	//Overload constructor
	
	public Products(String VegetableName, double pricePerPoundVegetable, String fruitName, double pricePerPoundFruit) {
		
		this.vegetableName = VegetableName;
		this.pricePerPoundVetgetable = pricePerPoundVegetable;
		this.fruitName = fruitName;
		this.pricePerPoundFruit = pricePerPoundFruit;
	}

	//Methods
	public double calculateSubtotal() {
		double subtotal = (pricePerPoundVetgetable * vegetablesOrdered) + (pricePerPoundFruit * fruitsOrdered) ;
		return subtotal;
	}
	public double calculateAdditionalFees() {
		double additionalFee = calculateSubtotal() * SERVICE_RATE + DELIVERY_FEE;
		return additionalFee;
		
				
	}
	//This method will display the order summary
	public void displayOrderSummary() {
		System.out.println("Grocery Shopping Order Summary\n");
		System.out.printf("%-20sPounds Ordered\n", "Name: ","Pounds Ordered:" );
		System.out.printf("%-20s%.2f\n", this.vegetableName , this.vegetablesOrdered );
		System.out.printf("%-20s%.2f\n", this.fruitName, this.fruitsOrdered );
		
		System.out.printf("\n%-20s$%.2f","Sub-total: ",  calculateSubtotal());
		System.out.printf("\n%-20s$%.2f" ,"Additional Fee:",   calculateAdditionalFees());
		System.out.printf("\n%-20s$%.2f" , "Total Bill:", (calculateSubtotal() + calculateAdditionalFees()));
		System.out.println("\n-------------------------------------");
	}
	
	
	
	//Getters and Setters
	
	public String getVegetableName() {
		return vegetableName;
	}
	
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public double getPricePerPoundVetgetable() {
		return pricePerPoundVetgetable;
	}

	public void setPricePerPoundVetgetable(double pricePerPoundVetgetable) {
		this.pricePerPoundVetgetable = pricePerPoundVetgetable;
	}

	public double getVegetablesOrdered() {
		return vegetablesOrdered;
	}

	public void setVegetablesOrdered(double vegetablesOrdered) {
		this.vegetablesOrdered = vegetablesOrdered;
	}

	public double getPricePerPoundFruit() {
		return pricePerPoundFruit;
	}

	public void setPricePerPoundFruit(double pricePerPoundFruit) {
		this.pricePerPoundFruit = pricePerPoundFruit;
	}

	public double getFruitsOrdered() {
		return fruitsOrdered;
	}

	public void setFruitsOrdered(double fruitsOrdered) {
		this.fruitsOrdered = fruitsOrdered;
	}

	
	
	
}

