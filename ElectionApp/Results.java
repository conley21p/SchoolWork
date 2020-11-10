/*
* File name: Results.java
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
* <This class stores all of the candidates in an array using aggregation.>
*
* @ConleyJoesphPrice
*
*/
public class Results
{
	//create Scanner object
	Scanner scan = new Scanner(System.in);
	
	//constant
	public final int BLOCK_SIZE = 3;
	
	//instance variables
	private Candidate[] candidate;
	private int actualCan;
	private String[] offices;
	private int actualOff;
	
//methods
	//•	Constructor: Set a default constructor that does the following:
		//1. Instantiates the two arrays to BLOCK_SIZE.
		//2. Sets the two size variables to 0.
	public Results() {
		this.candidate = new Candidate[BLOCK_SIZE];
		this.actualCan = 0;
		this.offices = new String[BLOCK_SIZE];
		this.actualOff = 0;
	}
	
	
	//getters
	public int getActualCan()
	{
		return actualCan;
	}
	public int getActualOff()
	{
		return actualOff;
	}

	
	//to String
		//For each item in the array
	public String toString() {
		String output = null;
		for(int i = 0; i  < candidate.length; i++) {
			output += "Candidate" + (i+1) + ": " +  candidate[i] + "\n"; 
		}
		return output;
		
	}
	
	//•	hasCandidate: 
		//This method accepts a Candidate and using a 
		//for loop, searches the candidate array for the received candidate. 
		//If the candidate is found, return true. Otherwise, return false.
	public boolean hasCandidate(Candidate c) {
		
		for(int i = 0; i < actualCan; i++) {
			if(c.equals(candidate[i])) {
				return true;
			}
		}
		return false;
	}
	
	//•	isCandidatesFull: 
		//This method returns true if the size of the array
		//matches the length of the array. Otherwise, it returns false.
	public boolean isCandidateFull() {
		if(candidate.length == actualCan) 
			return true;
		else return false;
	}
	
	//•	isOfficeFull: 
		//This method returns true if the size of the array
		//matches the length of the array. Otherwise, it returns false.
	public boolean isOfficesFull() {
		if(offices.length == actualOff) 
			return true;
		else return false;
	}
	
	//•	addCandidate(Candidate c): 
			//This private method accepts the candidate that will be added to the array.
				//o	First you must verify that the list is not full. If it is full, then you 
					//call the resizeCandidate method. 
				//o	Create a new instance of candidate and add it to the candidates array.
				//o	Determine whether this is a new office by searching the office array for 
					//a match. If no match (or array is empty), add the office to the office 
					//array, but you must first determine if the array is full, and if so, resize it. 
	public void addCandidate(Candidate c ) {
		candidate[actualCan] = c;
		++actualCan;
		if(!c.getOffice().equals(offices[0]) && !c.getOffice().equals(offices[1]))
			{
				offices[actualOff] = c.getOffice();
				++actualOff;
			}
		
		
	}
	
	//•	addCandidate(): 
		//This method will prompt and accept user input to get the information
			//needed to create a candidate. 
		//o	It will use the hasCandidate method to ensure that a candidate is 
			//not on the list before being added to the list. If candidate is already on the list,
			//return a message that reads, “Candidate already on ballot.”
		//o	If candidate is not on the list, then call the overloaded addCandidate 
			//method and pass in the candidate to be added. 
	public void addCandidate() {
	
		System.out.print("Enter the first name: ");
		String firstN = scan.nextLine();
		System.out.print("Enter the last name: ");
		String lastN = scan.nextLine();
		System.out.print("Enter the candidate's office: ");
		String office = scan.nextLine();
		System.out.print("Enter the candidate's party: ");
		String party = scan.nextLine();
		
		Candidate addCan = new Candidate(firstN, lastN, office, party);
		System.out.println(hasCandidate(addCan));
		if(hasCandidate(addCan)) {
			System.out.println("Candidate already on ballot");
		}else addCandidate(addCan);
		
	}
	
	
	
	//addVotes() 
		//This method will prompt the user to enter votes for each candidate.
	public void addVotes() {
		System.out.println(actualCan);
			for(int i = 0; i < actualCan; i++ ) {
			System.out.print("Enter votes for " + candidate[i].getFirstN() + " " + candidate[i].getLastN() + ": " );
			candidate[i].setVotes(scan.nextInt());
			
		}
	}
	//•	determineWinner() 
		//This method will display a list of offices that currently have candidates
		//and the user will choose which office they want to determine winner for. 
		//It will build a menu of offices, from the offices array and display it to the user. 
		//It will call the method 
		//createCandidateListByOffice and will pass the users input to the method. 
	public void determineWinner() {
//		System.out.println(actualOff + Arrays.toString(offices));
//		System.out.println(actualCan + Arrays.toString(candidate));
		int counter = 0;
		for(int i = 0; i < actualOff; i ++) {
			System.out.print((i+1) + "- " + offices[i] + "\n");
			counter++;
		}
		int input = 0;
		if(counter>1) {
		System.out.print("Select office you want to determine winner of (Enter #1-" + counter + "): " );
		input = scan.nextInt();
		} else {
			System.out.print("Select office you want answer for (Enter #1): ");
			input = scan.nextInt();
		}

		//System.out.println(Arrays.toString(offices));
		switch(input) {
			case(1):
				int winner = 0;
			//boolean isAWinner2 = false;
			String output = "\nNo one has votes. Winner Can not be determined\n\n";
			for(int i = 0; i < actualCan; i++) 
			{
				if(candidate[i].getOffice().equals(offices[1])) 
				{
					System.out.println(candidate[i].toString() + "\nVotes: " + candidate[i].getVotes() + "\n***********************");
					if (candidate[i].getVotes() > winner) 
					{
						winner = candidate[i].getVotes();
						output ="The Winner is: " +  candidate[i].getFirstN() + " "+ candidate[i].getFirstN();
						
					}else if(candidate[i].getVotes() == winner) output = "It is a tie";
					}
				}
			
			System.out.println(output + "\n\n");
				break;
			case(2):
				int winner2 = 0;
				//boolean isAWinner2 = false;
				String output2 = "\nNo one has votes. Winner Can not be determined\n\n";
				for(int i = 0; i < actualCan; i++) 
				{
					if(candidate[i].getOffice().equals(offices[1])) 
					{
						System.out.println(candidate[i].toString() + "\nVotes: " + candidate[i].getVotes() + "\n***********************");
						if (candidate[i].getVotes() > winner2) 
						{
							winner2 = candidate[i].getVotes();
							output2 ="The Winner is: " +  candidate[i].getFirstN() + " "+ candidate[i].getFirstN();
							
						}else if(candidate[i].getVotes() == winner2) output2 = "It is a tie";
						}
					}
				
				System.out.println(output2 + "\n\n");
				break;
		}
		
	}
	//•	createCandidateListByOffice()
		//This private method accepts user input and will build a temporary array that
		//contains a list of all candidates that are running for the specific office the user has selected. 
	
	//•	findHighestVotes() 
		//This private method receives the temporary array and the size of the array from createCandidateListByOffice method. 
			//o	If there is only one candidate running for that office, then the candidate must have at least one vote to win. 
			//o	If there is more than one candidate, then it will search the temp array for the most votes 
				//for that office. Set the boolean won value for the winning candidate to true.
			//o	If the scores are equal, then there is no winner.

	//•	displayWinners()
		//This method outputs all candidates who have won their race. 
	
	
	
}
