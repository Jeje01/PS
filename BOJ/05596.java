import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s=0, t=0;
		int i;
		for(i=0; i<4; i++)
			s+=sc.nextInt();
		for(i=0; i<4; i++)
			t+=sc.nextInt();
		if(s==t)
			System.out.println(s);
		else
			System.out.println(Math.max(s, t));		
	}
}
