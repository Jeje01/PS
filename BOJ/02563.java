/**
 * 색종이 - S5
 * 구현, 브루트포스
 * 13052 kb
 * 84 ms
 * 
 * * 풀이
 * 배열의 크기가 100*100이므로 모든 연산을 해도 가능함
 * boolean[][] 배열에 색종이가 있는 곳 표시
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_02563_색종이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static boolean[][] map = new boolean[101][101];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			for(int j=a; j<a+10; j++) {
				for(int k=b; k<b+10; k++) {
					map[j][k] = true;
				}
			}
		}
		int answer = 0;
		for(boolean[] row: map) {
			for(boolean b: row) {
				if(b) {
					answer++;
				}
			}
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
