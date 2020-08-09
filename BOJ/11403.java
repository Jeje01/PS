/**
 * 경로 찾기
 * 그래프 이론
 * 24,452 kb
 * 336 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static boolean[] visited;
	static LinkedList<Integer>[] list;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[][] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		list = new LinkedList[N];
		answer = new int[N][N];
		for(int i=0; i<N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int[] tmp = new int[N];
			for(int j=0; j<N; j++) {
				tmp[j] = Integer.parseInt(tokens.nextToken());
				if(tmp[j]==1) {
					list[i].add(j);
				}
			}
		}
		
		//출력
		//0~N-1까지 큐로 돌리면서 배열에 넣기
		for(int i=0; i<N; i++) {
			queue.clear();
			visited = new boolean[N];
			for(int j=0; j<list[i].size(); j++) {
				queue.offer(list[i].get(j));
			}
			while(!queue.isEmpty()) {
				int next = queue.poll();
				visited[next]=true;
				answer[i][next]=1;
				for(int j=0; j<list[next].size(); j++) {
					if(visited[list[next].get(j)])
						continue;
					queue.offer(list[next].get(j));
				}
			}
		}
		for(int[] row: answer) {
			for(int a: row) {
				output.append(a).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
		
	}

}
