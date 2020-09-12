/**
 * 욕심쟁이 판다 - G3
 * DFS, DP
 * 41,840 kb
 * 444 ms
 * 
 * 각 자리에서 DFS, DP 2차원 배열에 결과 저장
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
	static int n, map[][], dp[][], K;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	static int dfs(int r, int c) {
		if(dp[r][c]!=-1) return dp[r][c];
		int currentMax=1;
		for(int i=0; i<4; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
			if(map[nr][nc]>map[r][c]) {
				currentMax = Math.max(currentMax, 1+dfs(nr, nc));
			}
		}
		dp[r][c] = currentMax;
		K = Math.max(dp[r][c], K);
		return currentMax;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(input.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dfs(i, j);
			}
		}

		output.append(K);
		System.out.println(output.toString());
	}
}
