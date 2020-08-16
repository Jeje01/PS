/**
 * 미네랄 - G3
 * 시뮬레이션, BFS
 * 24,224 kb
 * 308 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] map;
	static int R, C, N;
	static int[] shoots;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;
	static List<Pos> list = new ArrayList<>();
	static List<Pos> moveTo = new ArrayList<>();
	
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
	
	static void dfs(int r, int c, int move) {
		visited[r][c] = true;
		if(move!=-1) {
			map[r][c] = '.';
			moveTo.add(new Pos(r-move, c));
		}
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<=0 || nr>=map.length || nc<=0 || nc>=map[0].length || map[nr][nc]=='.' || visited[nr][nc]) {
				continue;
			}
			
			dfs(nr, nc, move);
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		// 입력 받기
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R+1][C+1];
		// 뒤집어서 배열 받기
		for(int i=R; i>0; i--) {
			String line = input.readLine();
			for(int j=0; j<line.length(); j++) {
				map[i][C-j] = line.charAt(j);
			}
		}
		N = Integer.parseInt(input.readLine());
		shoots = new int[N];
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			shoots[i] = Integer.parseInt(tokens.nextToken());
		}
		// 던질 때 마다
		for(int i=0; i<shoots.length; i++) {
			visited = new boolean[R+1][C+1];
			list.clear();
			moveTo.clear();
			int height = shoots[i];
			int move = Integer.MAX_VALUE; // 떨어질 거리
			// 던져서 없애기
			if(i%2==0) { // 오른쪽에서 던질 때
				for(int j=C; j>0; j--) {
					if(map[height][j]=='x') {
						map[height][j]='.';
						break;
					}
				}
			}else { // 왼쪽에서 던질 때
				for(int j=1; j<C+1; j++) {
					if(map[height][j]=='x') {
						map[height][j]='.';
						break;
					}
				}
			}
			
			// 바닥에 붙어있는 클러스터 검사
			int r=1;
			for(int c=1; c<C+1; c++) {
				if(map[r][c]=='x') {
					dfs(r, c, -1);
				}
			}
			
			// 떠있는 것 찾기 - 바닥 좌표 저장
			for(r=2; r<R+1; r++) {
				for(int c=1; c<C+1; c++) {
					if(map[r][c]=='x' && !visited[r][c]) {
						list.add(new Pos(r, c));
					}
				}
			}
			
			// 떠있는 클러스터 없으면 넘어가기
			if(list.size()==0)
				continue;
			
			// 떠있는 클러스터의 모든 좌표마다 바닥/클러스터까지의 거리 구하기
			for(int j=0; j<list.size(); j++) {
				Pos tmp = list.get(j);
				// c 고정
				int k;
				for(k=tmp.r-1; k>0; k--) {
					if(map[k][tmp.c]=='x' && visited[k][tmp.c]) {
						move = Math.min(move, tmp.r-k-1);
						break;
					}
				}
				if(k==0) {
					move = Math.min(move, tmp.r-1);
				}
			}
			if(move==Integer.MAX_VALUE)
				move = -1;
			// 클러스터 move만큼 옮기기

			dfs(list.get(0).r, list.get(0).c, move);
			
			for(int j=0; j<moveTo.size(); j++) {
				map[moveTo.get(j).r][moveTo.get(j).c] = 'x';
				
			}
		}

		for(int i=R; i>0; i--) {
			for(int j=C; j>0; j--) {
				output.append(map[i][j]);
			}
			if(i!=1)
				output.append("\n");
		}
		System.out.println(output.toString());
	}

}

 
