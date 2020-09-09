/**
 * 외판원 순회 - G1
 * DP, 비트마스킹, DFS, 외판원 순회
 * 17,812 kb
 * 160 ms
 * 
 * 순환하기 때문에 한 지점에서만 구하면 됨
 * 0->1->2->3->0 과 2->3->0->1->2는 같음 : 한 지점에서만 구하면 됨
 * 
 * 현재까지 방문한 곳 제외 (현재 위치->0)까지의 최소 경로를 dp에 저장
 * 
 * MAX를 Integer.MAX_VALUE를 써주면 안 됨
 * -> Integer.MAX_VALUE+α 계산 시 overflow 발생
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
	static int N, W[][], dp[][]; // dp : memoization
	static long answer;
	static int MAX = 987654321; // Integer.MAX_VALUE 사용 시 overflow 발생
	
	static int getDis(int flag, int n) {
		if(flag==((1<<N)-1)) { // 모든 지점 전부 탐색 시
			if(W[n][0]!=0) { // 시작점인 0으로 가는 경로가 존재할 경우
				return W[n][0]; // 마지막점 -> 시작점의 비용 return
			}
			// n -> 0 경로 존재하지 않을 시 Math.min에서 적은 값이 되면 안되므로 MAX 값 리턴
			return MAX; 
		}
		if(dp[n][flag]!=MAX) { // dp에 값이 들어온 적이 있다면
			return dp[n][flag]; // dp 값 리턴
		}
		int ret = MAX; // 반환할 값 초기화
		// ret : 현재 flag에서 방문한 곳 제외 현재 위치에서 0까지 가는 최솟값 저장
		for(int i=0; i<N; i++) {
			if(W[n][i]==0 || (flag &1<<i)!=0) continue; // 경로가 없거나 방문한 지점이면 continue
			ret = Math.min(ret, W[n][i]+getDis(flag|1<<i, i)); // (지금 위치 -> 다음 위치) + (다음 위치에서 반환될 값) 
		}
		dp[n][flag] = ret; // dp 값에 ret 값 넣음
		return ret; // n지점에서 이때까지 flag의 값을 방문한 경로의 최솟값 리턴
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		W = new int[N][N];
		answer = MAX;
		dp = new int[N][1<<N];
		// dp 초기화
		for(int[] row: dp) {
			Arrays.fill(row, MAX);
		}
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 0 지점에서 출발
		output.append(getDis(1, 0));
		System.out.println(output.toString());
	}
	
}
