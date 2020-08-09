/**
 * N과 M(2)
 * 조합
 * 12,968 kb
 * 80 ms
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
	static int N, M;
	static int[] arr;
	
	static void makeCombination(int r, int start, int[] temp) {
		if(r==M-1) {
			for(int i=0; i<temp.length; i++) {
				output.append(temp[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=start; i<arr.length; i++) {
			temp[r+1]=arr[i];
			makeCombination(r+1, i+1, temp);
		}

	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		makeCombination(-1, 0, new int[M]);
		System.out.println(output.toString());
		
	}

}
