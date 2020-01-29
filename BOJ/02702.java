import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j;
		int a, b, gcd;
		int[][] answer = new int[n][2];
		for(i=0; i<n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			gcd=1;
			for(j=1; j<Math.min(a,b); j++) {
				if(a%(j+1)==0&&b%(j+1)==0) {
					gcd=j+1;
				}
			}
			answer[i][0]=(a/gcd)*b;
			answer[i][1]=gcd;
		}
		for(i=0; i<n; i++) {
			System.out.println(answer[i][0]+" "+answer[i][1]);
		}	
	}	
}
