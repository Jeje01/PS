/**
 * 좌표 정렬하기
 * 정렬
 * 63,734 kb
 * 832 ms
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
	static int[][] arr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		Arrays.sort(arr, (o1, o2)->{
			if(o1[0]==o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});
		for(int[] row: arr) {
			for(int a: row) {
				output.append(a).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}

}
