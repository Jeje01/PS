import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, n, j;
		int[] ans = new int[t];
		for(i=0; i<t; i++) {
			n= sc.nextInt();
			int[] arr= new int[n];
			for(j=0; j<n; j++)
				arr[j]=sc.nextInt();
			Arrays.sort(arr);
			ans[i]=arr[n-1]-arr[0];
		}
		for(i=0; i<t; i++)
			System.out.println(ans[i]*2);
	}
}
