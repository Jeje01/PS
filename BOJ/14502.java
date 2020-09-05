/**
 * 연구소 - G5
 * 브루트포스, DFS, BFS
 * 22,344 kb
 * 312 ms
 * 
 * * 풀이
 * 각각의 바이러스를 막을 벽을 구하는 방법이 있지 않을까 했지만 아니었음
 * 벽을 세우는 모든 경우의 수를 다 계산해야 했음
 * 처음에는 BFS로 했지만 DFS를 사용하는 게 훨씬 효율적
 * 매번 초기화하는 배열의 경우 새로 선언하는 것보다 값을 넣어주는 게 더 효율적
 * 의미없는 가지치기의 경우 괜히 연산하는 시간만 추가해서 더 비효율적일수도 있음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, map[][], safe, unsafe, walls, tmp[][], answer, spreaded;
	static boolean[][] visited;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	static void spread(int r, int c) {
		spreaded++;
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || tmp[nr][nc]!=0) continue;
			visited[nr][nc] = true;
			spread(nr, nc);
		}
	}
	
	static int[] getPos(int x) {
		return new int[] {x/M, x%M};
	}
	
	static void dfs(int idx, int start) {
		if(idx==3) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					visited[i][j] = false;
					tmp[i][j] = map[i][j];
				}
			}
			spreaded = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] || tmp[i][j]!=2) continue;
					spread(i, j);		
				}
			}
			unsafe = Math.min(unsafe, spreaded);
			return;
		}
		for(int i=start; i<N*M; i++) {
			int[] pos = getPos(i);
			if(map[pos[0]][pos[1]]!=0) continue;
			map[pos[0]][pos[1]]=1;
			dfs(idx+1, i+1);
			map[pos[0]][pos[1]]=0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		visited = new boolean[N][M];
		unsafe = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j]==1) {
					walls++;
				}
			}
		}
		dfs( 0, 0);
		safe = N*M-unsafe-walls-3;
		output.append(safe);
		System.out.println(output.toString());

	}
}
