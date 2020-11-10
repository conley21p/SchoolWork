/*
* File name: AutoSalesOrder.java
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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/**
* <This class keeps track of the information for each customer order>
*
* @ConleyJoesphPrice
*
*/
public class AutoSalesOrder
{
	//constants
	public static final double OIL_CHANGE_PAC = 299.99, TIRE_ROTATION_PAC = 149.50, CAR_WASH_PAC = 499.99,
								VEHICLE_TAX = .035, SERVICE_TAX = .08, SERVICE_REBATE = .02;
	
	//instances variables
	private String orderDate, vehicleDescrip;
	private double orderPrice, vehiclePrice, vehicleTax, vehicleSub, servicePacPrice, serviceTax,
					servicePacSub, serviceCash, serviceRebate;
	private boolean  oilPacIndicator, tirePacIndicator, washPacIndicator;
	
	
	//constructor 
	public AutoSalesOrder(String todaysDate) {
		this.orderDate = todaysDate;
	}
	public AutoSalesOrder(String vehicleDescrip, double vehiclePrice) {
		this.vehicleDescrip = vehicleDescrip;
		this.vehiclePrice = vehiclePrice;
	}
	
	
	//method get values for the service cash vehicle subtotal
	public void setVehiclePrice() {
		DecimalFormat df = new DecimalFormat("#.00");
		vehicleTax = Double.parseDouble(df.format(vehiclePrice * VEHICLE_TAX));
		serviceCash = Double.parseDouble(df.format(vehiclePrice * SERVICE_REBATE));
		vehicleSub = vehiclePrice + vehicleTax;
		orderPrice = vehicleSub;
	}
	
	private void calculateOrderLineItemCost() {
		
		//Set value for the order price and service package subtotal from the users input
		if (oilPacIndicator ) {
			servicePacSub = OIL_CHANGE_PAC;	
		} else { servicePacSub = 0;}
		if(tirePacIndicator) {
			servicePacSub = servicePacSub +  TIRE_ROTATION_PAC;
		}
		if(washPacIndicator) {
			servicePacSub = servicePacSub +  CAR_WASH_PAC;
		}
		
		//calculate service package tax
		serviceTax = servicePacSub * SERVICE_TAX;
		//calculate rebate amount also add service package subtotal to the overall order price
		if (servicePacSub <= serviceCash) {
			serviceRebate = servicePacSub;
			orderPrice = orderPrice + servicePacSub + serviceTax - serviceRebate;
		} else {serviceRebate = serviceCash;
				orderPrice= orderPrice + servicePacSub + serviceTax - serviceRebate; }	
		
		
	}
	
	
	
	//Getter And Setters
	public String getVehicleDescrip()
	{
		return vehicleDescrip;
	}
	public void setVehicleDescrip(String vehicleDescrip)
	{
		this.vehicleDescrip = vehicleDescrip;
	}
	public double getOrderPrice()
	{
		return orderPrice;
	}
	public double getServiceCash()
	{
		return serviceCash;
	}
	public void setVehiclePrice(double vehiclePrice)
	{
		this.vehiclePrice = vehiclePrice;
	}
	public void setOilPacIndicator(String indicator)
	{
		if (indicator.toLowerCase().equals("y")){
			oilPacIndicator = true;
		}else {oilPacIndicator = false;}	
	}
	public void setTirePacIndicator(String indicator)
	{
		if (indicator.toLowerCase().equals("y")){
		tirePacIndicator = true;
		} else {tirePacIndicator = false;}
	}
	public void setWashPacIndicator(String indicator)
	{
		if (indicator.toLowerCase().equals("y")){
		washPacIndicator = true;
		calculateOrderLineItemCost();
		}else { washPacIndicator = false;
		calculateOrderLineItemCost();}
	}
	NumberFormat f = NumberFormat.getCurrencyInstance();

	public String toString() {
		String tS8;
		if (oilPacIndicator== true) {tS8 = "\t3-year oil change package\n";} else { tS8 = "";}
		if (tirePacIndicator== true) {tS8 = tS8 + "\t3-year tire rotation package\n";}
		if (washPacIndicator== true) {tS8 = tS8 + "\t3-year car wash package\n"; System.out.println(tS8);}else {System.out.println(tS8);}
		Date orderDate = new Date();
		return "-------------------------------------------------------"
				+ "\nAUTO SALES ORDER RECEIPT"
				+ "\nOrder Date:" + orderDate 
				+ "\n-------------------------------------------------------\n"
				+ String.format("%-49sAmount\n", "Item")
				+ "-------------------------------------------------------\n"
				+ String.format("Vehicle"+ "\n\t" + vehicleDescrip + "\n")
				+ String.format("   %-19s %32s\n", "Sales Price", f.format(vehiclePrice))
				+ String.format("   %-19s %32s\n", "Sales Tax", f.format(vehicleTax))
				+ String.format("   %-19s %32s\n\n", "Subtotal", f.format(vehiclePrice + vehicleTax))
		
				+ String.format("Service Package\n" )
				+ tS8
				+ String.format("   %-19s %32s\n", "Sale Price", f.format(servicePacSub))
				+ String.format("   %-19s %32s\n", "Sales tax", f.format(serviceTax))
				+ String.format("   %-19s %32s\n", "Rebate", f.format(serviceRebate))
				+ String.format("   %-19s %32s\n", "Sales Price", f.format(servicePacSub + serviceTax - serviceRebate))
				+ "-------------------------------------------------------\n"
				+ String.format("%-22s %32s\n", "Grand Total", f.format(orderPrice))
				+ "-------------------------------------------------------\n";
		
	}
	
	

}
