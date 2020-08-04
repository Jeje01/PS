/**
 * Generations of Tribbles
 * DP
 * 12,856 kb
 * 72 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		dp = new long[68];
		for(int i=0; i<dp.length; i++) {
			switch(i) {
				case 0:
				case 1:
					dp[i] = 1;
					break;
				case 2:
					dp[i] = 2;
					break;
				case 3:
					dp[i] = 4;
					break;
				default:
					dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
			}
		}
		for(int i=1; i<=T; i++) {
			int tmp = Integer.parseInt(input.readLine());
			output.append(dp[tmp]).append("\n");
		}
		System.out.println(output.toString());

	}

}
