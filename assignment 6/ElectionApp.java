/*
* File name: ElectionApp.java
*
* Programmer: Conley Price
* ULID: cjpric2
*
* Date: Nov 5, 2019
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
* <This is your main program. 
* This class will display the menu and drive all the activities.>
*
* @ConleyJoesphPrice
*
*/
public class ElectionApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int menuAns = 0;
		Results candidates = new Results();
		
		//validate the user input is in the range 1-6
		while(menuAns != 6) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose from the following options: \r\n" + 
				"1- Add a candidate\r\n" + 
				"2- Add votes\r\n" + 
				"3- Determine winner\r\n" + 
				"4- Display a list of candidates\r\n" + 
				"5- Display winners\r\n" + 
				"6- Exit" + 
				"");
		System.out.print("Enter Here: ");
		if(scan.hasNextInt())
			menuAns = scan.nextInt();
		
		while(menuAns < 1 || menuAns > 5 && menuAns != 6) {
			System.err.println("\nError(Please enter a Number 1 - 6)");
			System.out.println("Choose from the following options: \r\n" + 
					"1- Add a candidate\r\n" + 
					"2- Add votes\r\n" + 
					"3- Determine winner\r\n" + 
					"4- Display a list of candidates\r\n" + 
					"5- Display winners\r\n" + 
					"6- Exit" + 
					"");
			System.out.print("Enter Here: ");
			if(scan.hasNextInt())
				menuAns = scan.nextInt();
		}
			switch(menuAns) {
				case(1):
					candidates.addCandidate();
					break;
				case(2):
					candidates.addVotes();
					break;
				case(3):
					candidates.determineWinner();
					break;
				case(4):
					
					break;
				case(5):
					
					break;
			
		}
		}
		
		
		//when they enter 6
		System.out.println("\n\nYou have exited");
	}

}
