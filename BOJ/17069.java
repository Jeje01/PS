/**
 * 파이프 옮기기 2 - G5
 * DP, DFS
 * 144,16 kb
 * 88 ms
 * 
 * 파이프 옮기기 1과 같은 문제이지만 범위가 다름
 * int를 사용하면 오버플로우 남 -> long으로 바꾸면 AC
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static long map[][], answer, dp[][][];
	static int[][] dirs = {{0, 1}, {1, 0}, {1, 1}};
	static int[][] dirEach = {{0, 2}, {1, 2}, {0, 1, 2}}; // 가로, 세로, 대각선
	
	static long dfs(int r, int c, int dir) {
		if(dp[r][c][dir]!=-1) {
			return dp[r][c][dir];
		}
		if(r==N && c==N) {
			return 1;
		}

		long sum=0;
		int[] move = dirEach[dir];
		for(int i=0; i<move.length; i++) {
			int nr = r+dirs[move[i]][0];
			int nc = c+dirs[move[i]][1];
			if(nr>=N+1 || nc>=N+1 || map[nr][nc]==1) continue;
			if(move[i]==2 && (map[nr-1][nc]==1 || map[nr][nc-1]==1)) continue;
			sum+= dfs(nr, nc, move[i]);
		}
		return dp[r][c][dir] = sum;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new long[N+1][N+1];
		dp = new long[N+1][N+1][3];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		for(long[][] rows: dp) {
			for(long[] row: rows) {
				Arrays.fill(row, -1);
			}
			
		}
		for(int i=0; i<3; i++) {
			dp[N][N][i] =1; 
		}
		long answer = dfs(1, 2, 0);
		output.append(answer);
		System.out.println(output.toString());
		
	}
}
