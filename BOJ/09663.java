/**
 * N-Queen - G5
 * 백트래킹, 브루트포스
 * 14,884 kb
 * 3,620 ms
 * 
 * 각 행, 각 열마다 퀸 한 개씩 존재
 * 위치 저장할 때 열을 인덱스로 가지는 1차원 배열이면 충분
 * 대각선 중복될 시에 탐색 stop
 * 대각선 중복 체크 : |r1-r2|==|c1-c2| 확인
 */
 
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, answer;
	
	static void dfs(int flag, int c, int[] pos) {
		if(c==N+1) {
			answer++;
			return;
		}
		for(int i=1; i<=N; i++) {
			if((flag & 1<<i)!=0) continue;
			// 현재 겹치는 게 있으면 stop
			boolean check = false;
			for(int j=c-1; j>0; j--) {
				if(Math.abs(c-j)==Math.abs(i-pos[j])) {
					check = true;
					break;
				}
			}
			if(check) continue;
			pos[c] = i;
			dfs(flag | 1<<i, c+1, pos);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(0, 1, new int[N+1]);
		System.out.println(answer);
	}

}
 
