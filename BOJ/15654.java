/**
 * N과 M(5)
 * 순열
 * 32,784 kb
 * 252 ms
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
	
	static void makePermutation(int r, int[] temp, boolean[] visited) {
		if(r==M-1) {
			for(int a: temp) {
				output.append(a).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			temp[r+1]=arr[i];
			makePermutation(r+1, temp, visited);
			visited[i] = false;
		}
		
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);

		makePermutation(-1, new int[M], new boolean[N]);
		System.out.println(output.toString());

	}

}
