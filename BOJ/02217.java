import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N];
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			dp[i] = arr[N-i-1]*(i+1);
		}
		for(int i=0; i<N; i++)
			answer = answer>dp[i] ? answer : dp[i];
		System.out.println(answer);
	}

}
