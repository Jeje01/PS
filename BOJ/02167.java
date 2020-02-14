import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int i, j, l, sum;
		for(i=0; i<n; i++) {
			for(j=0; j<m; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int k = sc.nextInt();
		int[] ans = new int[k];
		for(i=0; i<k; i++) {
			sum=0;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(j=a-1; j<c; j++) {
				for(l=b-1; l<d; l++) {
					sum+=arr[j][l];
				}
			}
			ans[i]=sum;
		}
		for(i=0; i<k; i++)
			System.out.println(ans[i]);
	}	
}
