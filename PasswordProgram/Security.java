/*
* File name: Security.java
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

/**
* <This class will have methods to  to generated passwords, encrypt messages and decrypt coded messages>
*
* @ConleyJoesphPrice
*
*/
public class Security
{
	
	
	public static String generatePassword(String password) {
		
		// first character to upper case
		password = Character.toString(password.charAt(0)).toUpperCase()	+ password.substring(1);
		
		//check for s char
		password = password.replace('s', '$');
		password = password.replace('S', '$');
		//check for a char
		password = password.replace('a', '@');
		password = password.replace('A', '@');
		//check for 0 char 
		password = password.replace('o', '0');
		password = password.replace('O', '0');
		//check for e char
		password = password.replace('e', '3');
		password = password.replace('E', '3');
		//check for space
		password = password.replace(' ', '_');
		int length = password.length();
	
		//if previous char is upper case then make next lower
		for (int counter = 1; counter < length; counter++ ) {	
			if (Character.toLowerCase(password.charAt(counter)) == password.charAt(counter) ) {
				if (Character.toLowerCase(password.charAt(counter-1)) == password.charAt(counter-1) ) {
					char c = password.charAt(counter);
					char C = Character.toUpperCase(c);
				if(counter == 1 ) {
					password = password.charAt(counter-1) + (Character.toString(password.charAt(counter))).toUpperCase() + password.substring(counter + 1);
				}else 	password = password.substring(0, counter ) + (Character.toString(password.charAt(counter))).toUpperCase() + password.substring(counter + 1);			
		}	}	}
		
	
		//if previous char is upper case then make next lower
		for (int counter = 1; counter < length; counter++ ) {	
			if (Character.toUpperCase(password.charAt(counter)) == password.charAt(counter) ) {
				if (Character.toUpperCase(password.charAt(counter-1)) == password.charAt(counter-1) ) {
					char c = password.charAt(counter);
					char C = Character.toLowerCase(c);
				if(counter == 1 ) {
						password = password.charAt(counter-1) + (Character.toString(password.charAt(counter))).toLowerCase() + password.substring(counter + 1);
				} else 	password = password.substring(0, counter ) + (Character.toString(password.charAt(counter))).toLowerCase() + password.substring(counter + 1);			
				}	}	}
		
		//if no special charaters add a 
		boolean indicator = true;
		for ( int counter = 0; counter < length; counter++) {
			if(indicator == true) {
			if(Character.toString(password.charAt(counter)).equals("$"))indicator = false;
			if(Character.toString(password.charAt(counter)).equals("3")) indicator = false;
			if(Character.toString(password.charAt(counter)).equals("_"))indicator = false;
			if(Character.toString(password.charAt(counter)).equals("@")) indicator = false;
			if(Character.toString(password.charAt(counter)).equals("0")) indicator = false;
			}
			}
		
		if ( indicator == true ) { password += "!"; }
		
		//Add number of of digits to password to the end
		password += length;
				
			return password;}
	

		
		
		
		public static String CaesarCipher(String password, int shift) {
			
			int length = password.length();
			
			//shift the character from the phrase 
			for (int a = 0; a < length; a++ ) {
				int c = 0;
				char b = password.charAt(a);
				if (b == Character.toUpperCase(b)){
						c = (int)b;
					 	char d;
					 	
			 			if ((c + shift) < 90) {
			 				d =(char)(c + shift);
			 			}else {d = (char)(c + shift - 26); }
			 			
			 			password = password.substring(0, a) + d + password.substring(a + 1);
			 			
				}else {
					//for lowercase letters
					c = (int)b;
					char d;
					//if characters need to loop back to assign value
					if ((c + shift) < 123) {
						d =(char)(c + shift);
					}else {d = (char)(c + shift - 26); }
					
					password = password.substring(0, a) + d + password.substring(a + 1);
					
				}
				
			}return password;}
		
		public static String CaesarDecrypt(String password, int shift) {
			
			int length = password.length();
			
			//go through letter by letter to change the characters back to the message
			for (int a = 0; a < length; a++ ) {
				int c = 0;
				char b = password.charAt(a);
				if (b == Character.toUpperCase(b)){
						c = (int)b;
					 	char d;
					 	
			 			if ((c - shift) > 64) {
			 				d =(char)(c - shift );
			 			}else {d = (char)(c - shift +26); }
			 			
			 			password = password.substring(0, a) + d + password.substring(a + 1);
			 			
				}else {
					//if they are uppercase
					c = (int)b;
					char d;
					if ((c - shift) >= 97) {
						d =(char)(c - shift);
					}else {d = (char)(c - shift + 26); }
				
					password = password.substring(0, a) + d + password.substring(a + 1);
					
				}
				
			}return password;}

		
		//creates static variables so I can call them in the main method
		static boolean aIndicator = true;
		static boolean indicator1 = false;
		static boolean indicator2 = false;
		static boolean indicator3 = false;
		
		public static String vigenerEncrypt(String text, String key) {
			
			
			//Initiate  values for method
			aIndicator = true;
			indicator1 = false;
			indicator2 = false;
			indicator3 = false;
			
			int t ;
			int k ;
			
			String vText = null, error;
						
				text = text.toUpperCase();
				key = key.toUpperCase();
				
				t = text.length();
				k = key.length();
				
				//check if tect is longer than key
				if (t < k) {
					aIndicator = false; 
					indicator1 = true;
				}
				
				//check if text string is all letters
				for (int a = 0; a < text.length(); a++ ) {
					if (Character.isLetter(text.charAt(a)) == false) {
						aIndicator = false;
						indicator2 = true;
					}
				}
							
				//check if key string is all letters
				for (int a = 0; a < key.length(); a++ ) {
					if (Character.isLetter(key.charAt(a)) == false) {
							aIndicator = false;
							indicator3 = true;
					}
				}
							
			//calculate values to make the key to the same length of the phrase
			int dif = t - k;
			//mod will be the extra characters that the key needs to repeat to equal phrase
			int mod = dif%k;
			//dif will be the amount of times key will repeat plus 1 to equal phrase length
			dif = dif/k;
			char v;
			
			// the key isn't 8 characters or the text and key don't only contain letters
			//then it will display errors
			if ( indicator1 == true || indicator2 == true || indicator3 == true) {

				vText ="";
				if(Security.indicator1 == true)System.err.println("Text needs to be longer key");
				if ( Security.indicator2 == true )System.err.println( "Text needs to be all letters");
				if ( Security.indicator3 == true ) System.err.println("key needs to be all letters");
				
			}else {	
				//else make key the same length as the phrase 
				for (int a = 0; a < dif; a++ ) {
					key += key;
				}
				for( int a = 0; a < mod; a++) {
					key += key.charAt(a);
				}
				
				//	Execute the encryption
				System.out.println((int)text.charAt(0) );
				System.out.println((int)key.charAt(0));
				for (int a = 0; a < t; a++ ) {
					int b = (int)text.charAt(a) + (int)key.charAt(a) - 130;
					
					int charac = 65 + b;
					if(charac < 91) {
					v = (char)(charac);
							if (a < 1 ) { vText = Character.toString(v);}
							else vText += Character.toString(v);
					} else {
						charac = charac-26;
						v = (char)(charac);
						if (a < 1 ) { vText = Character.toString(v);}
						else vText += Character.toString(v);
					}
				
			}
			}
			vText = vText.toUpperCase();
			return vText;
		}

		
		//decrypt the vigener code
		public static String vigenerDecrypt(String code, String key) {
			
			//initiate variables
				String vText = null, error;
			
				aIndicator = true;
				indicator1 = false;
				indicator2 = false;
				indicator3 = false;
			
							
				code = code.toUpperCase();
				key = key.toUpperCase();
				
				
				int c = code.length();
				int k = key.length();
				//check if code is longer than the key
				if (c < k) {
					aIndicator = false; 
					indicator1 = true;
				}
			
				
				//check if text string is all letters
				
				for (int a = 0; a < code.length(); a++ ) {
					if (Character.isLetter(code.charAt(a)) == false) {
						aIndicator = false;
						indicator2 = true;
					}
				}
							
							//check if key string is all letters
				for (int a = 0; a < key.length(); a++ ) {
					if (Character.isLetter(key.charAt(a)) == false) {
							aIndicator = false;
							indicator3 = true;
					}
				}
							

				//calculate values to make the key to the same length of the phrase
				int dif = c - k;
				//mod will be the extra characters that the key needs to repeat to equal phrase
				int mod = dif%k;
				//dif will be the amount of times key will repeat plus 1 to equal phrase length
				dif = dif/k;
				char v;
				
				
				// the key isn't 8 characters or the text and key don't only contain letters
					//then it will display errors
				if ( indicator1 == true || indicator2 == true || indicator3 == true) {

					System.out.println("Error:");
					if ( Security.indicator1 == true ) System.out.print("The key needs to be shorter then the text. Retry.\n");
					if ( Security.indicator2 == true ) System.out.print("Text needs to be all letters\n");
					if ( Security.indicator3 == true ) System.out.print("key needs to be all letters\n");
					
					System.out.println("Please retry\n");
					
				}else {
					//else make key the same length as the phrase 
					for (int a = 0; a < dif; a++ ) {
						key += key;
					}
					for( int a = 0; a < mod; a++) {
						key += key.charAt(a);
					}
					
					//Then do the vigner decrypting
					for (int a = 0; a < c; a++ ) {
						int b = (int)code.charAt(a) - (int)key.charAt(a) + 65;
						if (b < 64) 
							{v = (char)(b+26);
								if (a < 1 ) { vText = Character.toString(v);}
								else vText += Character.toString(v);
						}else {
							v = (char)(b);
								if (a < 1 ) { vText = Character.toString(v);}
								else vText += Character.toString(v);}
						}
					vText = vText.replace('@', 'A');
				
				}
			return vText;
		}	
	}
	
	
	
	
	

