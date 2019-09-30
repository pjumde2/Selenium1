package test;

import java.util.Scanner;

public class Triangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number:");
		num=scan.nextInt();
		System.out.println(" "+"1");
		for(int i=1;i<=num;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(" "+i+" ");
			}
			System.out.println();
		}

	}

}
