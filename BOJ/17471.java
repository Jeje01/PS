/**
 * 게리맨더링 - G5
 * 14,452 kb
 * 108 ms
 * 
 * 딱히 방법이 생각이 안 나면 다 해보는 게 방법일수도
 * 부분집합 대신 1 ~ N/2 개의 조합을 구해도 됨
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17471_게리맨더링 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, answer;
	static int[] pop;
	static int[][] arr;
	static boolean[] visited, nums;
	static Queue<Integer> queue = new LinkedList<>();
	
	static class Pos{
		int n;
		int group;
		
		public Pos(int n, int group) {
			super();
			this.n = n;
			this.group = group;
		}
		
	}
	
	static boolean checkGroup(int flag) {
		nums = new boolean[N+1];
		nums[0] = true;
		for(int i=1; i<=N; i++) {
			if((flag & (1<<i))!=0) {
				queue.offer(i);
				break;
			}
		}
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			nums[tmp] = true;
			for(int i=0; i<arr[tmp].length; i++) {
				int next = arr[tmp][i];
				if(((1<<next) & flag) !=0 && !nums[next]) {
					queue.offer(next);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if((flag & (1<<i))==0) {
				queue.offer(i);
				break;
			}
		}
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			nums[tmp] = true;
			for(int i=0; i<arr[tmp].length; i++) {
				int next = arr[tmp][i];
				if(((1<<next) & flag) ==0 && !nums[next]) {
					queue.offer(next);
				}
			}
		}
		for(boolean a: nums) {
			if(a==false) return false;
		}
		return true;
		
	}

	static void subset(int flag, int idx) {

		if(idx==N+1) {
			if(flag==0 || flag==(1<<(N-1)) || visited[flag]) return;
			int tmp = (1<<(N+1))-1;
			visited[flag] = true;
			visited[tmp^flag] = true;
			if(!checkGroup(flag)) return;
			int first = 0, second = 0;
			for(int i=1; i<=N; i++) {
				if((flag & (1<<i))==0) {
					first+=pop[i];
				}else {
					second+=pop[i];
				}
			}
			answer = Math.min(answer, Math.abs(first-second));
			return;
		}

		subset(flag | (1<<idx), idx+1);
		subset(flag, idx+1);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		pop = new int[N+1];
		arr = new int[N+1][];
		tokens = new StringTokenizer(input.readLine());
		visited = new boolean[1<<(N+1)];
		answer = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			pop[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int size = Integer.parseInt(tokens.nextToken());
			int[] tmp = new int[size];
			for(int j=0; j<size; j++) {
				tmp[j] = Integer.parseInt(tokens.nextToken());
			}
			arr[i] = tmp;
		}

		subset(0, 1);
		if(answer==Integer.MAX_VALUE)
			answer = -1;
		output.append(answer);
		System.out.println(output.toString());
		
	}
}
