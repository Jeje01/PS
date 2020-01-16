import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int[] a = new int[n];
		int[] b = new int[n];
		int ca=0, cb=0;
		int i;
		for(i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		for(i=0; i<n; i++) {
			b[i]=sc.nextInt();
		}
		for(i=0; i<n; i++) {
			if(a[i]>b[i])
				ca++;
			else if(a[i]<b[i])
				cb++;
		}
		if(ca>cb) System.out.println("A");
		else if(ca<cb) System.out.println("B");
		else System.out.println("D");	
	}
}
