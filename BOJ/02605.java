/**
 * 줄 세우기 - B2
 * 구현
 * 13,072 kb
 * 84 ms
 * 
 * 반복 swap
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, arr[];
	
	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(input.readLine());
		arr = new int[n];
		tokens = new StringTokenizer(input.readLine(), " ");
		arr[0] = 1;
		tokens.nextToken();
		for(int i=1; i<n; i++) {
			arr[i] = i+1;
			int tmp = Integer.parseInt(tokens.nextToken());
			for(int j=i-1; j>=i-tmp; j--) {
				swap(j+1, j);
			}
		}
		for(int a: arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		
	}

}
