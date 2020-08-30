/**
 * N과 M (3) - S3
 * 순열
 * 111,948 kb
 * 372 ms
 * 
 * 입출력 주의
 * 출력 : BufferedReader 사용하지 않으면 시간 초과 뜸
 * 입력 : 1~7 사이의 정수 두 개 밖에 받지 않아도 Scanner보다 BufferedReader가 훨씬 빠름
 */
 
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	
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
			arr[idx] = i+1;
			perm(arr, idx+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		perm(new int[M], 0);
		System.out.println(output.toString());
	}
}
