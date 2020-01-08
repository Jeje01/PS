import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int a, b, i;
		for(i=0; i<n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			arr[i][0]=a/b;
			arr[i][1]=a%b;
		}
		for(i=0; i<n; i++) {
			System.out.println("You get "+arr[i][0]+" piece(s) and your dad gets "+arr[i][1]+" piece(s).");
		}		
	}
}
