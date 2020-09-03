/**
 * 해밀턴 순환회로
 * 백트래킹
 * 13,120 kb
 * 155 ms
 * 
 * 경로를 탐색하는 다른 알고리즘을 써야하나 했지만 단순한 백트래킹 문제였다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, answer, map[][];

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		answer = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		dfs(1, 1, 0, 0);
		output.append(answer);
		System.out.println(output.toString());
		
	}

	private static void dfs(int flag, int idx, int start, int total) {
		if(total>=answer) return;
		if(idx==N) {
			if(map[start][0]==0) return;
			answer = Math.min(answer, total+map[start][0]);
			return;
		}
		for(int i=1; i<N; i++) {
			if((flag&1<<i)!=0 || map[start][i]==0) continue;
			dfs(flag|1<<i, idx+1, i, total+map[start][i]);
		}
	}
}
