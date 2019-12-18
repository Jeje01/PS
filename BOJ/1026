import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int i, answer=0;
		for(i=0; i<n; i++)
			a[i] = sc.nextInt();
		for(i=0; i<n; i++)
			b[i] = sc.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		for(i=0; i<n; i++)
			answer+=a[i]*b[n-1-i];
		System.out.println(answer);
	}
}
