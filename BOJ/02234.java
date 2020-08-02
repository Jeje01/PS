/**
 * 성곽
 * BFS
 * 219,800 kb
 * 444 ms
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
	static int[][] walls, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] visited;
	static int rooms, m, n, maxRoom, broked, count;
	static int[] fourWalls, next, bitCalculate = {7, 11, 13, 14};
	static Queue<int[]> queue;
	
	public static void bfs(int r, int c) {
		
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			next = queue.poll();
			fourWalls = new int[4];
			int value = walls[next[0]][next[1]];
			int binary = 8, index=0;
			while(binary!=0) {
				if(value>=binary) {
					value-=binary;
					fourWalls[index++]=1;
					binary/=2;
				}else {
					index++;
					binary/=2;
				}
			}
			
			for(int i=0; i<dirs.length; i++) {
				int nr = next[0]+dirs[i][0];
				int nc = next[1]+dirs[i][1];
				if((nr>=0 && nr<m && nc>=0 && nc<n) && !visited[nr][nc] && fourWalls[i]==0) {
					queue.offer(new int[] {nr, nc});
					count++;
					visited[nr][nc] = true;
				}
			}
			
		}
		return;
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		queue = new LinkedList<int[]>();
		walls = new int[m][n];
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<n; j++) {
				walls[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		visited = new boolean[m][n];
		int cnt=0;
		
		// 1번, 2번
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					count=1;
					bfs(i, j);
					maxRoom = count>maxRoom? count: maxRoom;
					rooms++;
				}
			}
		}
		
		// 3번
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int tmp = walls[i][j];
				for(int k=0; k<bitCalculate.length; k++) {
					int nextBit = tmp&bitCalculate[k];
					if(nextBit!=tmp) {
						walls[i][j] = nextBit;
						count=1;
						queue = new LinkedList<int[]>();
						visited = new boolean[m][n];
						bfs(i, j);
						broked = count>broked? count: broked;
						walls[i][j] = tmp;
					}
				}
			}
		}
		System.out.println(rooms);
		System.out.println(maxRoom);
		System.out.println(broked);
		
	}

}
