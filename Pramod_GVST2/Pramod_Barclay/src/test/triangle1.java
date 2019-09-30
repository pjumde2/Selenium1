package test;

import java.util.Scanner;

public class triangle1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		
		Scanner scan=new Scanner (System.in);
		System.out.println("Enter number:");
		num=scan.nextInt();
		
		for(int i=1;i<=num;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(" "+i+" ");
				
			}
			System.out.println();
		}

	}

}
