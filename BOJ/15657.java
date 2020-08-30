/**
 * N과 M (8) - S3
 * 순열
 * 18,608 kb
 * 124 ms
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
	static int[] nums;
	
	static void perm(int[] arr, int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				output.append(arr[i]);
				if(i==M-1) {
					output.append("\n");
				}else {
					output.append(" ");
				}
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(idx!=0 && arr[idx-1]>nums[i]) continue;
			arr[idx] = nums[i];
			perm(arr, idx+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		nums = new int[N];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);
		perm(new int[M], 0);
		System.out.println(output.toString());
	}
}
