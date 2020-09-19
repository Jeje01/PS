/**
 * 빙고 - S5
 * 구현
 * 13,036 kb
 * 84 ms
 * 
 * 숫자마다 r, c 값을 저장
 * 숫자를 지울 때마다 그 숫자가 포함된 행, 열, 대각선의 개수--
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int pos[][], check[][];
	
	public static void main(String[] args) throws IOException {
		pos = new int[26][2];
		check = new int[3][5]; // 행, 열, 대각선 좌상향/우상향
		for(int[] row: check) {
			Arrays.fill(row, 5);
		}
		for(int i=0; i<5; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<5; j++) {
				int tmp = Integer.parseInt(tokens.nextToken());
				pos[tmp][0] = i;
				pos[tmp][1] = j;
			}
		}
		outerLoop: for(int i=0; i<5; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<5; j++) {
				int tmp = Integer.parseInt(tokens.nextToken());
				int x = pos[tmp][0];
				int y = pos[tmp][1];
				check[0][x]--;
				check[1][y]--;
				if(x+y==4) {
					check[2][1]--;
				}
				if(x==y) {
					check[2][0]--;
				}
				int cnt=0;
				for(int[] row: check) {
					for(int a: row) {
						if(a==0) {
							cnt++;
						}
					}
				}
				if(cnt>=3) {
					output.append(5*i+j+1).append("\n");
					break outerLoop;
				}
			}
		}
		System.out.println(output.toString());
		
	}
	
}
