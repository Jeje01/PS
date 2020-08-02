/**
 * 보물섬
 * BFS
 * 171,332 kb
 * 416 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] map;
	static int H, W, answer;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static Queue<int[]> queue;
	static boolean[][] visited;
	static HashSet<Integer> set = new HashSet<Integer>();
	
	public static void bfs(int startR, int startC, int cnt) {
		queue.offer(new int[] {startR, startC, cnt});
		visited[startR][startC] = true;
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			set.add(next[2]);
			for(int i=0; i<dirs.length; i++) {
				int nr = next[0]+dirs[i][0];
				int nc = next[1]+dirs[i][1];
				if((nr>=0 && nr<H && nc>=0 && nc<W) && map[nr][nc]=='L' && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc, next[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		map = new char[H][W];
		answer = Integer.MIN_VALUE;
		visited = new boolean[H][W];
		queue = new LinkedList<int[]>();
		for(int i=0; i<H; i++) {
			String line = input.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[H][W];
					queue = new LinkedList<int[]>();
					bfs(i, j, 0);
				}
			}
		}
		System.out.println(Collections.max(set));
	}
}
