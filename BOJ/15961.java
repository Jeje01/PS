/**
 * 회전 초밥 - G5
 * 170,244 kb
 * 528 ms
 * 
 * 매번 쿠폰을 고려하는 것보다 처음에 쿠폰 초밥의 값을 1로 해놓으면 됨
 * -> 0이 되지 않기 때문에 count 값에 영향을 주지 않음
 * 
 * 새로 들어오는 초밥 인덱스에서 뺄 초밥 인덱스를 계산하는 것 외에
 * -> 시작점과 끝점을 두 개로 관리할 수 있음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, d, k, c, answer;
	static int[] sushi;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		sushi = new int[N+k-1];
		int count=0;
		nums = new int[d+1];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(input.readLine());
		}

		for(int i=0; i<k-1; i++) {
			sushi[N+i] = sushi[i];
		}
		nums[c]++;
		count++;
		// 맨 처음 k개
		for(int i=0; i<k; i++) {
			if(nums[sushi[i]]==0) {
				count++;
			}
			
			nums[sushi[i]]++;			
		}

		answer = count;
		for(int i=k; i<sushi.length; i++) {
			int ns = i;
			int os = (i-k);
			nums[sushi[os]]--;
			if(nums[sushi[os]]==0) {
				count--;
			}
			if(nums[sushi[ns]]==0) {
				count++;
			}
			nums[sushi[ns]]++;
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}

}
