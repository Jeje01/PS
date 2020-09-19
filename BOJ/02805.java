/**
 * 나무 자르기 - S3
 * 이분 탐색
 * 173,184 kb
 * 496 ms
 * 
 * mid 계산은 제일 위에서
 * 적어도 M의 값이 나올 때이므로 if >=M 이어야 함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long N, M, arr[], max, mid, answer=-1;
	
	static long getLen(long x) {
		long sum=0;
		for(long a: arr) {
			sum += a>x? a-x: 0; 
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new long[(int)N];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			max = Math.max(max, arr[i]);
		}
		long left = 0, right = max;
		while(left<=right) {
			mid = (left+right)/2;
			long tmp = getLen(mid);
			if(tmp>=M) {
				answer = Math.max(answer, mid);
			}
			if(tmp>M) {
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		output.append(answer);
		System.out.println(output.toString());
	}

}
