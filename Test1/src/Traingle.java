import java.util.Scanner;

public class Traingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num,i,j;
		System.out.println("Please enter Number: ");
		
		Scanner scan = new Scanner(System.in);
		
		num=scan.nextInt();
		
		for(i=1;i<=num;i++)	
		{
			for(j=1;j<=i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		

	}

}
