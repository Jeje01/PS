import java.util.Scanner;

public class Main {
	public static void printBox(int a) {
		int i, j;
		for(i=0; i<a; i++) {
			for(j=0; j<a; j++) {
				if(i==0||i==a-1) {
					System.out.print("#");
				}
				else{
					if(j==0||j==a-1)
						System.out.print("#");
					else
						System.out.print("J");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		int[] arr = new int[n];
		for(i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		for(i=0; i<n; i++) {
			printBox(arr[i]);
		}
	}	
}
