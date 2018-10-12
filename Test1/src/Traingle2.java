import java.util.Scanner;

public class Traingle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num,j;
		
		System.out.println("Please enter number: ");
		Scanner scan=new Scanner(System.in);
		num=scan.nextInt();
		
		while(num>0)
		{
		
		for(j=1;j<=num;j++)
		{
			System.out.print(" "+num+" ");
		}
		System.out.println();
		num--;
		}

	}

}
