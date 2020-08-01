/**
 * 로봇 청소기
 * 시뮬레이션
 * 13,312 kb
 * 80 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서
	static int[][] map;
	static int cleaned;
	
	public static int turn(int d, int n) {
		d-=n;
		if(d<0)
			d+=4;
		return d;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine(), " ");
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		map[r][c] = 2;
		cleaned++;
		
		while(true) {
			int i=0;
			for(i=0; i<4; i++) {
				d = turn(d, 1);
				int nr = r+dirs[d][0];
				int nc = c+dirs[d][1];
				if((nr>=0 && nr<N && nc>=0 && nc<M) && map[nr][nc]==0) {
					map[nr][nc] = 2;
					r = nr;
					c = nc;
					cleaned++;
					break;
				}
			}
			if(i==4) {
				d = turn(d, 2);
				int nr = r+dirs[d][0];
				int nc = c+dirs[d][1];
				if((nr>=0 && nr<N && nc>=0 && nc<M) && map[nr][nc]==2) {
					r = nr;
					c = nc;
					d = turn(d, 2);
				}else {
					break;
				}
			}
		}
		System.out.println(cleaned);
		}
	}
