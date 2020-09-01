/**
 * 스타트와 링크 - S3
 * 브루트포스, 비트마스킹, 백트래킹
 * 28,136 kb
 * 240 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, answer;
	static boolean[] visited;
	static int[][] arr;
	
	static int getGap(int flag) { // 차이 계산
		int[] a = new int[N/2]; // 선택된 인덱스
		int[] b = new int[N/2]; // 선택 x
		int aIdx = 0, bIdx = 0;
		for(int i=0; i<N; i++) {
			if((flag & (1<<i))==0) {
				a[aIdx++]=i;
			}else {
				b[bIdx++]=i;
			}
		}
		int first = 0, second = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i+1; j<N/2; j++) {
				first += arr[a[i]][a[j]]+arr[a[j]][a[i]];
				second += arr[b[i]][b[j]]+arr[b[j]][b[i]];
			}
		}
		return Math.abs(first-second); // 차이 return
	}
	
	// 조합
	static void makeCombination(int flag, int cnt, int start) {
		if(cnt==N/2) { // N/2개 뽑을 때까지
			if(!visited[flag]) {
				int tmp = (1<<N)-1;   	  // 1111
				visited[flag] = true;     // 1100
				visited[tmp^flag] = true; // 0011
				answer = Math.min(answer, getGap(flag)); // 최솟값 넣기
			}
			return;
		}
		for(int i=start; i<N; i++) { 
			if((flag & 1<<i)!=0) { // 겹치는 게 있으면
				continue;
			}
			makeCombination(flag|(1<<i), cnt+1, i+1); // 현재 인덱스 포함
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		N = Integer.parseInt(input.readLine());
		arr = new int[N][N];
		answer = Integer.MAX_VALUE;
		visited = new boolean[1<<N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 조합
		makeCombination(0, 0, 0);
		output.append(answer);
		System.out.println(output.toString());
	}

}
