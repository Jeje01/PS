/*
 * 백조의 호수 - G1
 * BFS
 * 101,648 kb
 * 2,208 ms
 * 
 * 정수 저장은 문자 배열 말고 정수 배열에 하기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, answer;
	static char[][] map;
	static int[][] days;
	static boolean[][] visited;
	static List<Pos> swans = new ArrayList<>();
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static PriorityQueue<Route> queue = new PriorityQueue<Route>();
	
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static class Route implements Comparable<Route>{
		int r;
		int c;
		int value;
		public Route(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Route [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		@Override
		public int compareTo(Route o) {
			return Integer.compare(this.value, o.value);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		days = new int[R][C];
		for(int[] row: days) {
			Arrays.fill(row, -1);
		}
		answer = Integer.MAX_VALUE;
		for(int i=0; i<R; i++) {
			String line = input.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);	
				if(map[i][j]=='.') {
					days[i][j] = 0;
				}
				if(map[i][j]=='L') {
					swans.add(new Pos(i, j));
					days[i][j]=0;
				}
			}
		}

		char index=0;	
		while(true) {
			int count = 0;
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(days[i][j]==index) {
						for(int k=0; k<dirs.length; k++) {
							int nr = i+dirs[k][0];
							int nc = j+dirs[k][1];
							if((nr>=0 && nr<R && nc>=0 && nc<C) && map[nr][nc]=='X' && !visited[nr][nc]) {
								count++;
								days[nr][nc] = index+1;
								visited[nr][nc] = true;
								
							}
						}
					}
				}
			}			
			if(count==0) break;
			index++;
		}
		
		Pos start = swans.get(0);
		Pos end = swans.get(1);
		
		visited = new boolean[R][C];
		
		queue.offer(new Route(start.r, start.c, 0));
		visited[start.r][start.c]=true;
		
		while(!queue.isEmpty()) {
			Route tmp = queue.poll();
			if(tmp.r==end.r && tmp.c==end.c) {
				answer = Math.min(answer, tmp.value);
			}
			
			for(int i=0; i<dirs.length; i++) {
				int nr = tmp.r+dirs[i][0];
				int nc = tmp.c+dirs[i][1];
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
					queue.offer(new Route(nr, nc, Math.max(tmp.value, days[nr][nc])));
					visited[nr][nc] = true;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
