/**
 * 탈출 - G5
 * BFS
 * 17,352 kb
 * 156 ms
 * 
 * * 다른 풀이
 * 물을 매번 퍼뜨리지 않고, 각 지점마다 물이 되는 시간을 저장해서 사용 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C;
	static char[][] map;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	static Queue<Pos> oq = new LinkedList<>();
	static Queue<Pos> nq = new LinkedList<>();
	static Pos s;
	static List<Pos> list = new ArrayList<>();
	
	static class Pos{
		int r;
		int c;
		int time;
		
		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			map[i] = input.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='S') {
					s = new Pos(i, j, 0);
					map[i][j]='.';
					visited[i][j] = true;
				}
			}
		}
		nq.offer(s);
		outerLoop: while(true) {
			// 물 퍼뜨림 - 바로 퍼뜨리면 안 됨 -> 모아서 나중에 퍼뜨려야됨
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]=='*') {
						for(int d=0; d<4; d++) {
							int nr = i+dirs[d][0];
							int nc = j+dirs[d][1];
							if(nr>=R || nr<0 || nc<0 || nc>=C || map[nr][nc]!='.') 
								continue;
							list.add(new Pos(nr, nc, 0));
						}
					}
				}
			}
			// oq에 넣어주기
			while(!nq.isEmpty()) {
				oq.offer(nq.poll());
			}
			// 방문하지 않은 곳에 방문
			// S가 D에 도착하면 종료
			while(!oq.isEmpty()) {
				Pos next = oq.poll();
				if(map[next.r][next.c]=='*') continue;

				for(int d=0; d<4; d++) {
					int nr = next.r+dirs[d][0];
					int nc = next.c+dirs[d][1];
					if(nr>=R || nr<0 || nc<0 || nc>=C || !(map[nr][nc]=='.' || map[nr][nc]=='D') || visited[nr][nc]) 
						continue;						
					if(map[nr][nc]=='D') { // D에 도달하면 반복문 종료
						output.append(next.time+1);
						break outerLoop;
					}
					nq.offer(new Pos(nr, nc, next.time+1));
					visited[nr][nc] = true;
				}
				
			}
			
			// 물 퍼뜨려줌
			while(!list.isEmpty()) {
				Pos tmp = list.remove(0);
				map[tmp.r][tmp.c] = '*';
			}
			
			// 다음에 이동할 칸이 없으면
			if(nq.isEmpty()) {
				output.append("KAKTUS");
				break;
			}
		}
		System.out.println(output.toString());
		
	}
}
