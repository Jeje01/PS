import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i, sum=0, max=0;
		for(i=0; i<n; i++) {
			arr[i]= sc.nextInt();
		}
		for(i=0; i<n-1; i++) {
			if(arr[i]<arr[i+1]) {
				if(sum!=0)
					sum+=arr[i+1];
				else
					sum=arr[i]+arr[i+1];
			}
			else {
				max = max<sum? sum: max;
				sum=0;
			}
		}
		System.out.println(max);
		
	}	
}
