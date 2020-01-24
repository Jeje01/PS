import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int[] arr = new int[n];
		int i, sum=0;
		int cnt=1, max=0, value;
		for(i=0; i<n; i++) {
			arr[i]= sc.nextInt();
			sum+=arr[i];
		}
		System.out.println(sum/10);
		Arrays.sort(arr);
		value=arr[0];
		for(i=1; i<n; i++) {
			if(arr[i]==arr[i-1]) {
				cnt++;
			}
			else {
				if(max<cnt) {
					value=arr[i-1];
					max=cnt;
				}
				cnt=1;
			}				
		}
		System.out.println(value);
	}	
}
