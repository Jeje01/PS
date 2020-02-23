import java.util.Scanner;

public class Main{
	public static int getAns(int a, int b) {
		int i, g=1;
		for(i=1; i<Math.min(a, b); i++) {
			if(a%(i+1)==0 && b%(i+1)==0)
				g=i+1;
		}
		return a/g*b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = new int[n];
		int i;
		for(i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ans[i]=getAns(a, b);
		}
		for(i=0; i<n; i++)
			System.out.println(ans[i]);
		
	}
}
