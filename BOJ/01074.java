/**
 * Z - S1
 * Divide and Conquer
 * 13,008 kb
 * 80 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int answer;
	static long r, c;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		r = Long.parseLong(tokens.nextToken());
		c = Long.parseLong(tokens.nextToken());

		long rStart = 0;
		long rEnd = (long)Math.pow(2, N)-1;
		long rMid = 0;
		
		long plus = (long)Math.pow(Math.pow(2, N), 2)/2;
		
		long cStart = 0;
		long cEnd = (long)Math.pow(2, N)-1;
		long cMid = 0;
		boolean flag = true; // 가로
		while(true) {
			if(rStart>rEnd || cStart>cEnd)
				break;
			if(rStart==rEnd && cStart==cEnd) {
				break;
			}

			if(flag) {
				rMid = (rStart+rEnd)/2;
				if(r<=rMid) {
					rEnd = rMid;
				}else {
					answer+=plus;
					rStart=rMid+1;
				}
			}else {
				cMid = (cStart+cEnd)/2;
				if(c<=cMid) {
					cEnd = cMid;
				}else {
					answer+=plus;
					cStart=cMid+1;
				}
			}
			flag = !flag;
			plus/=2;
		}
		
		System.out.println(answer);

	}
}
