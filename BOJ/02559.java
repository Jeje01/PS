/**
 * 수열 - S3
 * 투 포인터
 * 23,448 kb
 * 216 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, arr[], answer;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		int sum=0, l=0;
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			if(i<K) {
				sum+=arr[i];
				answer = sum;
			}else {
				sum-=arr[l++];
				sum+=arr[i];
				answer = Math.max(answer, sum);
			}
		}
		output.append(answer);
		System.out.println(output.toString());
		
	}
}
