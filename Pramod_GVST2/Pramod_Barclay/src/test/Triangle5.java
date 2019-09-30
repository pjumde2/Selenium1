package test;

import java.util.Scanner;

public class Triangle5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no:");
		n=scan.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(((i+j)%2)+"");
			}
			System.out.println();
		}

	}

}
