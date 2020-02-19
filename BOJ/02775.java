import java.util.Scanner;

public class Main{
	public static int func(int k, int n) {
		int i, ans=0;
		if(k==0)
			return n;
		else {
			for(i=0; i<n; i++) {
				ans+=func(k-1, i+1);
			}
			return ans;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		int[] ans = new int[t];
		for(i=0; i<t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			ans[i] = func(k, n);
		}
		for(i=0; i<t; i++) {
			System.out.println(ans[i]);
		}
	}
}
