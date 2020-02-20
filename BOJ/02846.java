import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, start=0, up=0, max=0;
		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		for(i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(i=1; i<n; i++) {
			if(arr[i-1]<arr[i]) {
				if(up==0) {
					start=arr[i-1];
					up=1;
				}
			}
			else {
				if(up==1) {
					list.add(arr[i-1]-start);
					up=0;
				}
			}
		}
		if(up==1) {
			list.add(arr[n-1]-start);
		}	
		for(int a: list) {
			max = max<a? a: max;
		}
		System.out.println(max);
	}
}
