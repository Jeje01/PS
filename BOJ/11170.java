import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static int checkZero(int a, int b) {
		int ans=0, i, j;	
		for(i=a; i<=b; i++) {
			int[] digits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
			for(j=0; j<digits.length; j++) {
				if(digits[j]==0)
					ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m, i;
		int[] answer = new int[t];
		for(i=0; i<t; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			answer[i]=checkZero(n, m);
		}
		for(i=0; i<t; i++)
			System.out.println(answer[i]);
	}	
}
