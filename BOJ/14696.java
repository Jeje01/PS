/**
 * 딱지놀이 - B1
 * 구현
 * 27,480 kb
 * 244 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, arr[][];
	static char win;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[2][5];
		for(int n=1; n<=N; n++) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<5; j++) {
					arr[i][j] = 0;
				}
			}
			for(int k=0; k<2; k++) {
				tokens = new StringTokenizer(input.readLine());
				int cnt = Integer.parseInt(tokens.nextToken());
				for(int i=0; i<cnt; i++) {
					int tmp = Integer.parseInt(tokens.nextToken());
					arr[k][tmp]++;
				}
			}
			win = 'D';
			for(int i=4; i>0; i--) {
				if(arr[0][i]>arr[1][i]) {
					win = 'A';
					break;
				}else if(arr[0][i]<arr[1][i]) {
					win = 'B';
					break;
				}
			}
			output.append(win).append("\n");
		}
		System.out.println(output.toString());
	}
}
