/**
 * 곱셈 - S1
 * 수학, 분할정복
 * 12,892 kb
 * 84 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long A, B, C, answer;

	static long exp(long A, long B) {
		if(B==1) {
			return A;
		}
		
		long tmp = exp(A, B/2)%C;

		if(B%2==0) {
			return tmp*tmp%C;
		}else {
			return (tmp*tmp%C)*A%C;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		A = Long.parseLong(tokens.nextToken());
		B = Long.parseLong(tokens.nextToken());
		C = Long.parseLong(tokens.nextToken());
		output.append(exp(A%C, B));
		System.out.println(output.toString());
		
	}
}
