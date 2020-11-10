/*
* File name: Candidate.java
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

/**
* <This class records the information for each 
* candidate that is running for office.>
*
* @ConleyJoesphPrice
*
*/
public class Candidate
{
	//Instance variables 
	private String firstN, lastN, office, party;
	private int votes;
	private boolean win;
	
	
//methods
	//•	Custom constructor that accepts first and last name, office and party
	public Candidate(String firstN, String lastN, String office, String party) {
		this.firstN = firstN;
		this.lastN = lastN;
		this.office = office;
		this.party = party;
	}
	
	//•	Custom constructor that accepts an instance of another customer
	
	
	//Getters and setters
	public String getFirstN()
	{
		return firstN;
	}
	public void setFirstN(String firstN)
	{
		this.firstN = firstN;
	}
	public String getLastN()
	{
		return lastN;
	}
	public void setLastN(String lastN)
	{
		this.lastN = lastN;
	}
	public String getOffice()
	{
		return office;
	}
	public void setOffice(String office)
	{
		this.office = office;
	}
	public String getParty()
	{
		return party;
	}
	public void setParty(String party)
	{
		this.party = party;
	}
	public int getVotes()
	{
		return votes;
	}
	public void setVotes(int votes)
	{
		this.votes = votes;
	}
	public boolean isWin()
	{
		return win;
	}
	public void setWin(boolean win)
	{
		this.win = win;
	}
	public boolean getWin() {
		return this.win;
	}
	
	
	//to String method
	public String toString() {
		return    "Candidate: " + firstN + " " + lastN
				+ "\nOffice: " + office
				+ "\nParty: " + party;
	}
	
	
	//equals checks if candidate passed is equal to current candidate
		//equal if first and last name and parties are the same.
	public boolean equals(Candidate c) {
		if(this.firstN.equals(c.firstN) && this.lastN.equals(c.lastN) && this.party.equals(c.party))
			return true;
		else return false;
	}
	
	

}
