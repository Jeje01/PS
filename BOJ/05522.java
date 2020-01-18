import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, sum=0;
		for(i=0; i<5; i++)
			sum+=sc.nextInt();
		System.out.println(sum);
	}	
}
