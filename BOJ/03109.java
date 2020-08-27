/**
 * 빵집 - G2
 * 백트래킹, DFS, 그리디
 * 33,656 kb
 * 336 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, answer;
	static boolean[][] map;
	static int[] dirs = {-1, 0, 1};
		
	static void findWay(int r, int c, int[] way, int start) {
		if(!map[start][0] && c==C-1) return;
		if(c==C-1) {
			map[start][0] = false;
			answer++;
			return;
		}
		int d;
		for(d=0; d<dirs.length; d++) {
			int nr = r+dirs[d];
			if(nr>=0 && nr<R && map[nr][c+1]) {
				way[c+1] = nr;
				if(!map[start][0]) continue;
				map[nr][c+1] = false;
				findWay(nr, c+1, way, start);
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new boolean[R][C];
		int[] way = new int[C];
		for(int i=0; i<R; i++) {
			String line = input.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j)=='x'? false: true;
			}
		}
		
		for(int i=0; i<R; i++) {
			way[0] = i;			
			findWay(i, 0, way, i);
		}
		System.out.println(answer);
		
	}
}
