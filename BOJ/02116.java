/**
 * 주사위 쌓기 - G5
 * 브루트포스, DP
 * 20,424 kb
 * 176 ms
 * 
 * 첫 주사위의 바닥에 오는 면마다 dp로 최대 옆면의 값을 구해 그 중 최댓값을 구함
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, dice[], dp[], answer;
	static int[] opp = {0, 6, 4, 5, 2, 3, 1};
	static int[] cur = {}; // current bottom
	
	// A-F, B-D, C-E
	
	static int getMax(int a, int b) {
		int max = 0;
		for(int i=1; i<=6; i++) {
			if(i==a || i==b) continue;
			max = Math.max(i, max);
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		dice = new int[7];
		cur = new int[7];
		dp = new int[7]; // 첫 주사위의 자리가 i
		for(int i=0; i<N; i++) { // 주사위마다
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<=6; j++) {
				dice[j] = Integer.parseInt(tokens.nextToken());
			}

			int bottom, top;
			if(i==0) {
				for(int k=1; k<=6; k++) {
					bottom = dice[k];
					top = dice[opp[k]];
					cur[k] = top;
					dp[k] = getMax(bottom, top);
				}
			}else {
				for(int j=1; j<=6; j++) {
					bottom = cur[j];
					int bottomIdx=0;
					for(int k=1; k<=6; k++) {
						if(dice[k]==bottom) {
							bottomIdx = k;
							break;
						}
					}
					cur[j] = dice[opp[bottomIdx]];
					dp[j] += getMax(bottom, cur[j]);
				}
				
			}
			
			
		}
		for(int a: dp) {
			answer = Math.max(a, answer);
		}
		output.append(answer);
		System.out.println(output.toString());
	}
	 
}

 
