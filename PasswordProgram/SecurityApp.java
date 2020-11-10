/*
* File name: SecurityApp.java
*
* Programmer: Conley Price
* ULID: cjpric2
*
* Date: Oct 13, 2019
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
* <This driver class will be used to control the user interactions
* and call methods to find either the password, encryption ot decryption>
*
* @ConleyJoesphPrice
*
*/
public class SecurityApp
{
	//main menu method will ask the user what tool they want to use and take them to the next step
	private static int mainMenu() {
		int a = 0;
		Scanner scan = new Scanner(System.in);
		boolean error = true;
		//prompt user for the tool they want
		 while(a != 1 && a != 2 && a!=3  ) {
		  		    System.out.print("------------------------------------------------\n"
							+ "Thank you for coosing the IT-168 Security tool!\n"
							+ "------------------------------------------------\n"
							+ "Please select a tool from the options below: \n"
							+ "1. Password Generator\n"
							+ "2. Encryption Tool\n"
							+ "3. Decryption Tool\n"
							+ "Your Selection(1,2,3)-> ");
		  		    //if the user doesn't input a int the value won't be stored to a
					if(scan.hasNextInt()) {a = scan.nextInt()	;}
					
					//if the user doesn't input 1 2 or 3 it will ask them again for a input
					while(a != 1 && a!=2 && a!=3) {
						scan.nextLine();
						  System.out.print("------------------------------------------------\n"
									+ "Thank you for coosing the IT-168 Security tool!\n"
									+ "------------------------------------------------\n"
									+ "Please select a tool from the options below: \n"
									+ "1. Password Generator\n"
									+ "2. Encryption Tool\n"
									+ "3. Decryption Tool\n"
									+ "Your Selection(1,2,3)-> ");
						  if(scan.hasNextInt()) {a = scan.nextInt()	;}
					}
		 } 
		
		return a;
	}
	
	//This method will run is the user selects 1 in the main menu
	//and it will create a good password for the user
	private static void passwordSelection() {

		Scanner scan1 = new Scanner(System.in);
		
		String text = "";
		String error;
		int t = 0;
		boolean flag = false;
		Scanner s = new Scanner(System.in);
		
		//Will ask user for a phrase and will ask again if the phrase isn't 8 characters long
		while (text.length() < 8){
			System.out.println("Please enter a phraase that is at least 8 characters");
			text = scan1.nextLine();
	
		}
		
		System.out.println("\nYour Password is " + Security.generatePassword(text));
		
	}
	private static void encryptionSelection() {
		
		Scanner scan = new Scanner(System.in);
		int a = 0;
		
		//ask user for input if they dont put 1 or 2 dont accpet it
		System.out.print("Please Select a tool form the options below: "
						+ "\n1.Caeser Encryption"
						+ "\n2.Vigener Encryption"
						+ "\nyour Selction(1,2)-> ");
		if (scan.hasNextInt())  {a = scan.nextInt();}
		
		//ask again if input isn't valid
		while ( a != 1 && a != 2) {
			System.out.print("Please Select a tool form the options below: "
					+ "\n1.Caeser Encryption"
					+ "\n2.Vigener Encryption"
					+ "\nyour Selction(1,2)-> ");
		if (scan.hasNextInt()) { a = scan.nextInt();}
		scan.nextLine();
		}
		//if answer is 1 then ask for phrase and number you want shift and 
		//input it into the caeser method to get an encrypted code
		if(a == 1) {
			String text ="";
			String answer;
			int shift = 0 ;
			
			System.out.print("Please enter the phrase you want to Encrypt->");
			//read left over
			scan.nextLine();
			text = scan.nextLine();
			System.out.print("\nPlease enter the number of shifts you want-> ");
			if (scan.hasNextInt()) { shift = scan.nextInt();}
				
			
			while ( text.length() < 8  ) {
				System.out.println("Phrase needs to be longer than 8 characters");
				System.out.print("\nPlease enter the phrase you want to Encrypt->");
				//read left over
				scan.nextLine();
				text = scan.nextLine();
				System.out.print("\nPlease enter the number of shifts you want-> ");
				if (scan.hasNextInt()) { shift = scan.nextInt();}
				scan.nextLine();
			}
			answer = Security.CaesarCipher(text, shift);
			System.out.println("Encypted message is " + answer);
		}else {
			//if answer is 2 then ask for phrase and key and 
			//input it into the vigener method to get an encrypted code
			String text ="";
			String key = "";
			String answer;
			String taco = "";
			
			
			System.out.print("\nPlease enter the phrase you want to Encrypt->");
			//read left over
			scan.nextLine();
			text = scan.nextLine();
			System.out.print("\nPlease enter the key (needs to be shorter than phrase)-> ");
			key = scan.nextLine();
				 
			answer = Security.vigenerEncrypt(text, key);
			//if invalid input reask questions
			while ( Security.indicator1 == true || Security.indicator2 == true || Security.indicator3 == true) {
				System.out.print("\nPlease enter the phrase you want to Encrypt->  ");
				text = scan.nextLine();
				System.out.print("\nPlease enter the key (needs to be shorter than phrase)-> ");
				key = scan.nextLine();
				answer = Security.vigenerEncrypt(text, key);
			}
			
			System.out.println("Your Encypted message is " + answer);
		}
		
		}
		
				
	
	private static void decryptionSelection() {


		Scanner scan = new Scanner(System.in);
		int a = 0;
		
		//ask user for input if they dont put 1 or 2 dont accpet it
		System.out.print("Please Select a tool form the options below: "
						+ "\n1.Caeser Decryption"
						+ "\n2.Vigener Decryption"
						+ "\nyour Selction(1,2)-> ");
		if (scan.hasNextInt())  {a = scan.nextInt();}
		
		//ask again if input isn't valid
		while ( a != 1 && a != 2) {
			System.out.print("Please Select a tool form the options below: "
					+ "\n1.Caeser Decryption"
					+ "\n2.Vigener Decryption"
					+ "\nyour Selction(1,2)-> ");
		if (scan.hasNextInt()) { a = scan.nextInt();}
		//scan.nextLine();
		}
		//if answer is 1 then ask for phrase and number you want shift and 
				//input it into the caeser method to get an encrypted code
		if(a == 1) {
			String text ="";
			String answer;
			int shift = 0 ;
			
			System.out.print("\nPlease enter the phrase you want to Decrypt->");
			//read left over
			scan.nextLine();
			text = scan.nextLine();
			System.out.print("\nPlease enter the number of shifts you want-> ");
			if (scan.hasNextInt()) { shift = scan.nextInt();}
				
			//reask if the input is invalid
			while ( text.length() < 8  ) {
				System.out.print("\nPlease enter the phrase you want to Decrypt->");
				//read left over
				scan.nextLine();
				text = scan.nextLine();
				System.out.print("\nPlease enter the number of shifts you want-> ");
				if (scan.hasNextInt()) { shift = scan.nextInt();}
			}
			answer = Security.CaesarDecrypt(text, shift);
			//display coded message
			System.out.println("The secret message was " + answer);
		}else {
			//if answer is 2 then ask for phrase and key and 
			//input it into the vigener method to get an encrypted code
			String text ="";
			String key = "";
			String answer;
			String taco = "";
			
			
			System.out.print("\nPlease enter the phrase you want to Decrypt->");
			//read left over
			scan.nextLine();
			text = scan.nextLine();
			System.out.print("\nPlease enter the key (needs to be shorter than phrase)-> ");
			key = scan.nextLine();
				 
			answer = Security.vigenerDecrypt(text, key);
			//reask if input is invalid
			while ( Security.indicator1 == true || Security.indicator2 == true || Security.indicator3 == true) {

				System.out.print("\nPlease enter the phrase you want to Decrypt->   ");
				text = scan.nextLine();
				System.out.print("\nPlease enter the key (needs to be shorter than phrase)-> ");
				key = scan.nextLine();
				answer = Security.vigenerDecrypt(text, key);
			}
			//display coded message
			System.out.println("The secret message was " + answer);
		}
	}
	
	
	
	public static void main(String[] args)
	{	
		//tool is which the users answer to which tool he wants to use
		int tool = mainMenu();
		
		if (tool == 1) { 
			passwordSelection();	
		}else if (tool == 2) {
			encryptionSelection();
		}else if (tool == 3) {
			decryptionSelection();
		}else System.out.println("Error: Invalid Entry");
	}

}
