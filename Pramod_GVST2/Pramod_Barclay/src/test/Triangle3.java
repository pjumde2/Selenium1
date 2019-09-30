package test;

import java.util.Scanner;

public class Triangle3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number: ");
		num=scan.nextInt();
		
		while(num > 0){

            for(int j=1;j<=num;j++){

                System.out.print(" "+num+" ");

              }

              System.out.print("\n");

              num--;
		}
		
	}
	
}
