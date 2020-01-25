import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, leg=0, chi=0;
		int[][] arr = new int[t][2];
		for(i=0; i<t; i++) {
			leg=sc.nextInt();
			chi=sc.nextInt();
			arr[i][0]=chi*2-leg;
			arr[i][1]=chi-arr[i][0];
		}
		for(i=0; i<t; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}	
}
