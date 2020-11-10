/*
* File name: Auto.java
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

/**
* <THis class is the helper class and is useful for 
* storing vehicle information for the vehicle inventory>
*
* @ConleyJoesphPrice
*
*/
public class Auto
{
	private int year;
	private String make, model;
	private double price, mileage;
	
	public Auto(int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}

	public double getMileage()
	{
		return mileage;
	}

	public void setMileage(double mileage)
	{
		this.mileage = mileage;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getYear()
	{
		return year;
	}

	public String getMake()
	{
		return make;
	}

	public String getModel()
	{
		return model;
	}
	
	public String toString() {
		return year+ " " + make + " " + model;
	}

}
