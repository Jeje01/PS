/**
 * 알고스팟
 * 우선순위 큐
 * 13,780 kb
 * 104 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static PriorityQueue<Wall> q = new PriorityQueue<Wall>();
	static int M, N, answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	static class Wall implements Comparable<Wall>{
		int r;
		int c;
		int walls;
		
		public Wall(int r, int c, int walls) {
			super();
			this.r = r;
			this.c = c;
			this.walls = walls;
		}

		@Override
		public int compareTo(Wall o) {
			return Integer.compare(this.walls, o.walls);
		}

		@Override
		public String toString() {
			return "Wall [r=" + r + ", c=" + c + ", walls=" + walls + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		answer = Integer.MAX_VALUE;
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1; i<N+1; i++) {
			String line = input.readLine();
			for(int j=1; j<M+1; j++) {
				arr[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		q.offer(new Wall(1, 1, 0));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Wall tmp = q.poll();
			if(tmp.r==N && tmp.c==M) {
				answer = Math.min(answer, tmp.walls);				
			}
			for(int i=0; i<dirs.length; i++) {
				int nr = tmp.r + dirs[i][0];
				int nc = tmp.c + dirs[i][1];
				if(nr<=0 || nr>=arr.length || nc<=0 || nc>=arr[0].length || visited[nr][nc])
					continue;
				q.offer(new Wall(nr, nc, tmp.walls+arr[nr][nc]));
				visited[nr][nc] = true;
			}
		}
		System.out.println(answer);
		
	}

}
