import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i, gap=0, start=0, end=0, max=0;
		for(i=0; i<n; i++) {
			arr[i]= sc.nextInt();
		}
		for(i=0; i<n-1; i++) {
			if(arr[i]<arr[i+1]) {
				if(start==0) {
					start=arr[i];
					end=arr[i+1];
				}
				else
					end=arr[i+1];
			}
			else {
				gap=end-start;
				max = max<gap? gap: max;
				gap=0;
			}
		}
		System.out.println(max);	
	}	
}
