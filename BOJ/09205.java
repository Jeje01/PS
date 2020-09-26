/**
 * 맥주 마시면서 걸어가기 - S1
 * Dijkstra, 플로이드 와샬
 * 13,920 kb
 * 108 ms
 * 
 * 플로이드 와샬이 더 적합하지만 더 익숙학 다익스트라로 풀었다. 
 * 비용을 전달할 필요 없이 1000 이하이면 방문 표시를 해주면 됨
 * 배열을 int가 아닌 boolean으로 둬도 됨
 * 
 * 중간에 visited가 true가 되면 break하는 것으로 했을 때 오답이 나옴
 * 편의점을 모두 방문해야한다는 조건이 없는 거 같은데 틀리는 이유를 모르겠음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, arr[][];
	static boolean[] visited, check;
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	// 집 -> 페스티벌 
	// 처음 맥주 : 20 / 50미터에 1병 / 박스 맥주는 20 넘을 수 x
	
	static int getDis(int a, int b) {
		return Math.abs(arr[a][0]-arr[b][0])+Math.abs(arr[a][1]-arr[b][1]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(input.readLine());
			arr = new int[n+2][2];
			check = new boolean[n+2];
			visited = new boolean[n+2];
			for(int i=0; i<n+2; i++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				for(int j=0; j<2; j++) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());					
				}				
			}
			queue.offer(0);
			while(!queue.isEmpty()) {
				int p = queue.poll();
				if(visited[p]) continue;
				for(int i=1; i<n+2; i++) {
					int tmp = getDis(p, i);
					if(tmp<=1000) {
						queue.offer(i);
						check[i] = true;
						visited[p] = true;
					}
				}
			}
			if(!check[n+1]) {
				output.append("sad");
			}else {
				output.append("happy");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
		
		
	}
}
