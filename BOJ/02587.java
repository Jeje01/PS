import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int SIZE = 5;
		int i, sum=0;
		int[] arr = new int[SIZE];
		for(i=0; i<SIZE; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		Arrays.sort(arr);
		System.out.println(sum/SIZE);
		if(SIZE%2==0)
			System.out.println(arr[SIZE/2-1]);
		else
			System.out.println(arr[SIZE/2]);
		
	}
}
