import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i, sum=0;
		for(i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(i=0; i<n; i++) {
			sum+=arr[i]*(n-i);
		}
		System.out.println(sum);
	}
}
