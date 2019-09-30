package test;

import java.util.Scanner;

public class Triangle4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,c=0;;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number:");
		n=scan.nextInt();
		
		loop1: for(int i=1;i<=n;i++){

	         loop2: for(int j=1;j<=i;j++){

	                       if(c!=n){

	                            c++;

	                            System.out.print(c+" ");

	                       }

	                       else

	                           break loop1;

	                    }

	                    System.out.print("\n");

	                 }

	}

}
