/**
 * 요리사 - 모의 SW 역량테스트
 * 브루트포스, 비트마스킹, 백트래킹
 * 36,364 kb
 * 186 ms
 */
 
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_04012_요리사 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, answer;
	static int[][] map;
	static int[][] values;
	static boolean[] visited;
	
	static void pre() {
		for(int i=1; i<N; i++) {
			values[i] = new int[N+1];
			for(int j=i+1; j<N+1; j++) {
				values[i][j] = map[i][j]+map[j][i];
			}
		}
	}
	
	static void getGap(int flag) { 
		int[] first = new int[N/2];
		int[] next = new int[N/2];
		int fIdx = 0;
		int nIdx = 0;
		for(int i=1; i<N+1; i++) {
			if((1<<i & flag)!=0) {
				first[fIdx++] = i;
			}else {
				next[nIdx++] = i;
			}
		}
		int sum1 = 0, sum2 = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i+1; j<N/2; j++) {
				sum1+= values[first[i]][first[j]];
				sum2+= values[next[i]][next[j]];
			}
		}
		answer = Math.min(answer, Math.abs(sum1-sum2));
		return;
	}
	
	static void makeCombination(int n, int r, int i, int flag) {
		if(r==n) {
			int tmp = (int)Math.pow(2, N+1)-1;
			if(visited[flag]) return;
			getGap(flag);
			visited[flag] = true;
			visited[tmp^flag] = true;
			return;
		}
		if(i>=N+1) {
			return;
		}
		makeCombination(n, r+1, i+1, flag | 1<<i);
		makeCombination(n, r, i+1, flag);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(input.readLine());
			visited = new boolean[(int)Math.pow(2, N+1)];
			map = new int[N+1][N+1];
			for(int i=1; i<N+1; i++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j+1] = Integer.parseInt(tokens.nextToken());
				}
			}
			values = new int[N][N+1];
			pre();
			makeCombination(N/2, 0, 1, 0);
			
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output.toString());
	}

}
