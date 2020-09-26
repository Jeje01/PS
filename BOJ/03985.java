/**
 * 롤 케이크 - B1
 * 구현
 * 14,360 kb
 * 108 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int L, N, exp, act, expIdx, actIdx;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		L = Integer.parseInt(input.readLine());
		N = Integer.parseInt(input.readLine());
		visited = new boolean[L+1];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");	
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			if(exp<b-a+1) {
				exp = b-a+1;
				expIdx = i;
			}
			int cnt = 0;
			for(int j=a; j<=b; j++) {
				if(!visited[j]) {
					visited[j] = true;
					cnt++;
				}
			}
			if(act<cnt) {
				act = cnt;
				actIdx = i;
			}
		}
		output.append(expIdx).append("\n").append(actIdx);
		System.out.println(output.toString());
	}
}
