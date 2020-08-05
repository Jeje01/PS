/**
 * N과 M(1)
 * 순열
 * 26,116 kb
 * 244 ms
 */
 
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	
	static void permutation(int r, int[] temp) {
		if(r==0) {
			for(int i=temp.length-1; i>0; i--) {
				output.append(temp[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=1; i<arr.length; i++) {
			if(!visited[i]) {
				temp[r] = arr[i];
				visited[i] = true;
				permutation(r-1, temp);
				visited[i] = false;
			}
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<arr.length; i++) {
			arr[i] = i;
		}
		int[] temp = new int[M+1];
		permutation(M, temp);
		System.out.println(output.toString());
	}

}
