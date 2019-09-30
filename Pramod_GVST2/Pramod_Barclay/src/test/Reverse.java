package test;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String original,reverse="";
		Scanner scan = new Scanner(System.in);
		original=scan.nextLine();
		int length=original.length();
		
		for(int i=length-1;i>=0;i--)
		{
			reverse=reverse+original.charAt(i);
		}
System.out.println("Reverse string is: "+reverse);

	}

}
