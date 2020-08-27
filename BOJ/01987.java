/**
 * 알파벳 - G4
 * DFS, 백트래킹
 * 13,688 kb
 * 800 ms
 */
 
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, answer;
	static char[][] map;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	
	static int getFlag(int a, char ch) {
		return a | 1<<(ch-'A');
	}
	
	static int checkFlag(int a, char ch) {
		return a & 1<<(ch-'A');
	}
	
	static void dfs(int r, int c, int cnt, int flag) {
		answer = Math.max(answer, cnt);
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<0 || nr>=R || nc<0 || nc>=C || checkFlag(flag, map[nr][nc])!=0) continue;
			if(cnt+1==R*C) {
				answer = R*C;
				return;
			}
			dfs(nr, nc, cnt+1, getFlag(flag, map[nr][nc]));
		}
		return;
	}
	
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C= Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for(int i=0; i<R; i++) {
			map[i] = input.readLine().toCharArray();
		}
        dfs(0, 0, 1, getFlag(0, map[0][0]));
		System.out.println(answer);
		
	}
}
