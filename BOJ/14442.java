/**
 * 벽 부수고 이동하기 2 - G3
 * BFS
 * 361,630 kb
 * 1,252 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, K;
	static int[][] map;
	static int answer;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Queue<Info> queue = new LinkedList<>();
	static boolean[][][] visited;
	
	static class Info{
		int r;
		int c;
		int broke;
		int dis;
		
		public Info(int r, int c, int broke, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.broke = broke;
			this.dis = dis;
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		answer = Integer.MAX_VALUE;
		
		visited = new boolean[N][M][K+1];
		for(int i=0; i<N; i++) {
			String line = input.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		queue.offer(new Info(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Info tmp = queue.poll();
			if(tmp.r==N-1 && tmp.c==M-1) {
				answer = Math.min(answer, tmp.dis);
			}
			for(int i=0; i<dirs.length; i++) {
				int nr = tmp.r+dirs[i][0];
				int nc = tmp.c+dirs[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(tmp.broke+map[nr][nc]<=K && !visited[nr][nc][tmp.broke+map[nr][nc]]) {
						queue.offer(new Info(nr, nc, tmp.broke+map[nr][nc], tmp.dis+1));
						visited[nr][nc][tmp.broke+map[nr][nc]]=true;
					}
				}
			}
			
		}
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}

	}

}
 
