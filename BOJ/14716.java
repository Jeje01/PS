/**
 * 현수막 - G5
 * DFS, BFS
 * 23,964 kb
 * 204 ms
 * 
 * 기본 dfs 문제
 * 1인 곳을 탐색하며 0으로 바꿔주면 됨
 * 배열 boolean으로 해도 별로 차이 없음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N, map[][], answer;
	static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	static void dfs(int r, int c) {
		map[r][c] = 0;
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<0 || nr>=M || nc<0 || nc>=N || map[nr][nc]==0) continue;
			dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		map = new int[M][N];
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					dfs(i, j);
					answer++;
				}
			}
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
