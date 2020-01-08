import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, pos = 0;
		int[] arr = new int[9];
		int i;
		for(i = 0; i<9; i++)
			arr[i] = sc.nextInt();
		for(i = 0; i<9; i++) {
			if(max<arr[i]) {
				max = arr[i];
				pos=i;
			}	
		}
		System.out.println(max);
		System.out.println(pos+1);	
	}
} 
