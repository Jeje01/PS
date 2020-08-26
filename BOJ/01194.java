/**
 * 달이 차오른다, 가자. - G1
 * BFS, 비트마스킹
 * 15,732 kb
 * 108 ms
 * 
 * 2^(열쇠 개수) 크기의 flag 관리
 * -> 비트마스킹으로 열쇠 유무 체크
 * 3차원 배열 관리 - visited[][][2^(열쇠 개수)]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, answer;
	static String line;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static Queue<PosInfo> queue = new LinkedList<PosInfo>();

	static class PosInfo{
		int dis;
		int r;
		int c;
		int key;
		
		PosInfo(int dis, int r, int c, int key) {
			this.dis = dis;
			this.r = r;
			this.c = c;
			this.key = key;
		}
	
	}

	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		line = "";
		map = new char[N][M];
		visited = new boolean[N][M][64];
		answer = -1;
		for(int i=0; i<N; i++) {
			line = input.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='0') {
					queue.offer(new PosInfo(0, i, j, 0));
					visited[i][j][0] = true;
				}
			}
		}
		while(!queue.isEmpty()) {
			PosInfo current = queue.poll();
			if(map[current.r][current.c]=='1') {
				answer = current.dis;
				break;
			}
			
			for(int i=0; i<dirs.length; i++) {
				int nr = current.r+dirs[i][0];
				int nc = current.c+dirs[i][1];
				if((nr<0 || nr>=N || nc<0 || nc>=M) || visited[nr][nc][current.key])
					continue;
				char tmp = map[nr][nc];
				if(tmp=='.' || tmp=='1' || map[nr][nc]=='0') {
					PosInfo tmpPos = new PosInfo(current.dis+1, nr, nc, current.key);
					queue.offer(tmpPos);
				}
				else if(tmp=='#') {
					continue;
				}
				else {
					if(tmp>='a' && tmp<='f') {
						PosInfo tmpPos = new PosInfo(current.dis+1, nr, nc, current.key | 1<<(tmp-97));
						queue.offer(tmpPos);
						visited[nr][nc][tmpPos.key] = true;
					}else if(tmp>='A' && tmp<='F') {
						if((current.key & 1<<(tmp-'A'))!=0) {
							PosInfo tmpPos = new PosInfo(current.dis+1, nr, nc, current.key);
							queue.offer(tmpPos);
							visited[nr][nc][current.key]=true;
						}
					}
				}
				visited[nr][nc][current.key] = true;

			}
		}
		output.append(answer);
		System.out.println(output.toString());
		
		
	}

}
