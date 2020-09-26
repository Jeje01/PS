/**
 * 암호코드 - S1
 * DP
 * 13,388 kb
 * 80 ms
 * 
 * 1차원 DP인 줄 알았는데 문자가 2개 붙어있는지 아닌지 두 경우를 생각해야 한다.
 * 입력 값에 제한을 많이 두지 않아 예외처리를 까다롭게 해줘야 한다.
 * 0이 나오면 첫번째 값이거나 그 전에 1, 2가 아닐 경우 해독할 수 없는 암호이다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int answer, MOD = 1000000, dp[][];
	
	public static void main(String[] args) throws IOException {
		String line = input.readLine();
		dp = new int[2][2];
		for(int i=0; i<line.length(); i++) {
			if(i==0) {
				if(line.charAt(0)!='0') {
					dp[0][0] = 1;							
				}
				continue;
			}
			int tmp = Integer.parseInt(line.substring(i-1, i+1));
			if(line.charAt(i)=='0') {
				if(line.charAt(i-1)!='1' && line.charAt(i-1)!='2') {
					dp[0][0] = 0;
					dp[0][1] = 0;
					break;
				}
				dp[1][0] = 0;
				dp[1][1] = dp[0][0];
			}else if(tmp<=26 && tmp>=1) {
				dp[1][0] = (dp[0][0]+dp[0][1])%MOD;
				dp[1][1] = dp[0][0];
			}else {
				dp[1][0] = (dp[0][0]+dp[0][1])%MOD;
				dp[1][1] = 0;
			}
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
		}
		answer = (dp[0][0]+dp[0][1])%MOD;
		output.append(answer);
		System.out.println(output.toString());
	}
	
}
