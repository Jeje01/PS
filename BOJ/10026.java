/**
 * 적록색약
 * DFS
 * 13,884 kb
 * 88 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static char[][] normal;
	static char[][] redGreen;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N;
	
	public static void dfs(char[][] map, int r, int c) {
		char tmp = map[r][c];
		map[r][c]='F';
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(tmp==map[nr][nc] && map[nr][nc]!='F') {
					dfs(map, nr, nc);
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		normal = new char[N][N];
		redGreen = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = input.readLine();
			for(int j=0; j<line.length(); j++) {
				normal[i][j] = line.charAt(j);
				redGreen[i][j] = line.charAt(j)=='G'? 'R': line.charAt(j);
			}
		}
		int a=0, b=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(normal[i][j]!='F') {
					dfs(normal, i, j);
					a++;
				}
				if(redGreen[i][j]!='F') {
					dfs(redGreen, i, j);
					b++;
				}
			}
		}

		System.out.println(a+" "+b);
	}

}
