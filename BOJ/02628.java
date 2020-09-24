/**
 * 종이 자르기 - S5
 * 수학
 * 130,28 kb
 * 80 ms
 * 
 * 최대 길이 가로와 세로 구해서 곱하기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, row[], col[], N, maxX, maxY;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		row = new int[R+1];
		col = new int[C+1];
		N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int d = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());
			if(d==0) {
				row[p] = -1;
			}else {
				col[p] = -1;
			}
		}
		int former=0;
		for(int i=1; i<row.length; i++) {
			if(row[i]==-1) {
				maxY = Math.max(i-former, maxY);
				former = i;
			}
		}
		maxY = Math.max(R-former, maxY);
		former = 0;
		for(int i=1; i<col.length; i++) {
			if(col[i]==-1) {
				maxX = Math.max(i-former, maxX);
				former = i;
			}
		}
		maxX = Math.max(C-former, maxX);

		output.append(maxX*maxY);
		System.out.println(output.toString());
		
	}
}
