/**
 * 아기상어 - G5
 * 시뮬레이션, BFS
 * 22,440 kb
 * 148 ms
 * 
 * 아기상어의 위치에서 먹을 물고기 구할 때 전체를 BFS 돌려서 모든 위치를 한번에 구하면 됨
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
	static int N, seconds, map[][], cnt[], eat, dis, disArr[][];
	static Queue<int[]> queue = new LinkedList<>();
	static Shark shark;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	static class Shark{
		int r;
		int c;
		int size;
		
		public Shark(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(tokens.nextToken());
				if(n==9) {
					shark = new Shark(i, j, 2);	
				}else {
					map[i][j] = n;
				}
			}
		}
		while(true) {
			dis = Integer.MAX_VALUE;
			int r = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			disArr = new int[N][N];
			getLength();
			boolean hasFish = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==0 || map[i][j]>=shark.size) continue;
					// 거리가 제일 가까운 것
					// 거리가 같으면 위쪽
					// 같으면 왼쪽
					// tmp에 넣음
					int curDis = disArr[i][j];
					if(curDis==0) continue; // 닿지 못할 경우 다음 탐색
					if(curDis<dis) {
						r = i;
						c = j;
						dis = curDis;
					}else if(curDis==dis) {
						if(i<r) {
							r = i;
							c = j;
						}else if(i==r) {
							if(j<c) {
								c=j;
							}
						}
					}
					hasFish = true;
				}
			}
			if(hasFish) {
				map[r][c] = 0;
				eat++;
				shark.r = r;
				shark.c = c;
				seconds+=dis;
			}else {
				break;
			}
			if(eat==shark.size) {
				shark.size++;
				eat=0;
			}
		}
		output.append(seconds);
		System.out.println(output.toString());
	}

	private static void getLength() {
		boolean[][] visited = new boolean[N][N];
		queue.offer(new int[]{shark.r, shark.c, 0});
		visited[shark.r][shark.c] = true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			disArr[tmp[0]][tmp[1]] = tmp[2];
			for(int i=0; i<dirs.length; i++) {
				int nr = tmp[0]+dirs[i][0];
				int nc = tmp[1]+dirs[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]>shark.size) continue;
				queue.offer(new int[] {nr, nc, tmp[2]+1});
				visited[nr][nc]=true;
			}
			
		}
		
	}
	
}
