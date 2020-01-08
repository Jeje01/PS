import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i;
		double sum=0;
		for(i=0; i<5; i++)
			sum+=Math.pow(sc.nextDouble(), 2);
		System.out.println((int)sum%10);
	}
}
