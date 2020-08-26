/**
 * 차이를 최대로 - S2
 * 순열
 * 13,800 kb
 * 108 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, answer;
	static int[] arr;
	
	
	static void makePermutation(int n, int[] nums, boolean[] visited) {
		if(n==0) {
			int sum = 0;
			for(int i=1; i<nums.length; i++) {
				sum+=Math.abs(nums[i]-nums[i-1]);
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			nums[n-1] = arr[i];
			visited[i] = true;
			makePermutation(n-1, nums, visited);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine(), " ");
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		makePermutation(N, new int[N], new boolean[N]);
		System.out.println(answer);
	}
}
