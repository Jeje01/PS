/**
 * 돌 그룹 - G5
 * DFS/BFS
 * 53,736 kb
 * 212 ms
 * 
 * Queue 파라미터에 int[]보다 String 넣는 게 더 효율적
 * Set으로 중복 관리하는 것보다 다차원 visited로 관리하는 게 더 효율적
 * 같은 조합일 경우 같은 결과가 생성되므로 순서를 유지할 필요 없음
 * BFS 사용하는 것보다 생성 가능한 모든 경우의 수를 DFS로 탐색하는 게 더 빠름
 * 처음 input 값이 모두 같을 경우 처리
 */
 
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int answer, sum;
	static int[] arr = new int[3];
	static boolean[][] visited = new boolean[1000][1000];
	
	static void dfs(int a, int b) {
		if(visited[a][b]) return;
		visited[a][b] = true;
		int[] tmp = {a, b, sum-a-b};
		int[][] com = {{0, 1}, {1, 2}, {0, 2}};
		for(int i=0; i<com.length; i++) {
			int[] nextIdx = com[i];
			if(tmp[nextIdx[0]]!=tmp[nextIdx[1]]) {
				int[] nextInt = tmp.clone();
				nextInt[nextIdx[0]] = tmp[nextIdx[0]]*2;
				nextInt[nextIdx[1]] = tmp[nextIdx[1]]-tmp[nextIdx[0]];
				if(nextInt[0]==nextInt[1] && nextInt[1]==nextInt[2]) {
					answer = 1;
					return;
				}
				Arrays.sort(nextInt);
				if(!visited[nextInt[0]][nextInt[1]]) {
					dfs(nextInt[0], nextInt[1]);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		if(arr[0]==arr[1] && arr[1]==arr[2]) {
			answer = 1;
		}else if(sum%3==0){
			Arrays.sort(arr);
			dfs(arr[0], arr[1]);
		}
		System.out.println(answer);
	}

}
