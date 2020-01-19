import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=1, b=0, tmp;
		int i;
		int k = sc.nextInt();
		for(i=0; i<k; i++) {
			tmp=b;
			b+=a;
			a=tmp;	
		}
		System.out.println(a+" "+b);
	}	
}
