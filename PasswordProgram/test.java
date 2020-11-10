package edu.ilstu;

public class test
{

	public static void main(String[] args)
	{
		String text = "ATTACK";
		String key = "LEMONN";
		
		int t = text.length();
		int k = key.length();
		
		int dif = t - k;
		int mod = dif%k;
		dif = dif/k;
		char v;
		String vText = null;
		
		
		
		for (int a = 0; a < dif; a++ ) {
			key += key;
		}
		for( int a = 0; a < mod; a++) {
			key += key.charAt(a);
		}
		System.out.println(key);
		
		
		for (int a = 0; a < t; a++ ) {
			int b = (int)text.charAt(a) + (int)key.charAt(a) - 65;
			System.out.println(b);
			System.out.println(((int)'A') + "A");
			if (b > 89) 
				{v = (char)(b-26);
					if (a < 1 ) { vText = Character.toString(v);}
					else vText += Character.toString(v);
			}else 
				{v = (char)b;
			}
					if (a < 1 ) { vText = Character.toString(v);}
					else vText += Character.toString(v);
		}
		
		
		
		System.out.println(vText);
	}

}
