/**
 * 녹색 옷 입은 애가 젤다지? - G4
 * BFS, 우선순위큐
 * 18,372 kb
 * 184 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static PriorityQueue<Pos> queue = new PriorityQueue<>();
	static int N, map[][], answer, idx;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int rupee;
		
		public Pos(int r, int c, int rupee) {
			super();
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.rupee, o.rupee);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) {
			idx++;
			N = Integer.parseInt(input.readLine());
			if(N==0) break;
			queue.clear();
			answer = Integer.MAX_VALUE;
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			queue.offer(new Pos(0, 0, map[0][0]));
			visited[0][0] = true;
			while(!queue.isEmpty()) {
				Pos tmp = queue.poll();
				if(tmp.r==N-1 && tmp.c==N-1)
					answer = Math.min(answer, tmp.rupee);
				for(int i=0; i<dirs.length; i++) {
					int nr = tmp.r+dirs[i][0];
					int nc = tmp.c+dirs[i][1];
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
					int next = tmp.rupee+map[nr][nc];
					if(next>=answer) continue;
					queue.offer(new Pos(nr, nc, next));
					visited[nr][nc] = true;
				}
			}
			output.append("Problem ").append(idx).append(": ").append(answer).append("\n");
		}
		System.out.println(output.toString());
	}
}
