/**
 * 택배 - G4
 * Greedy, 정렬
 * 23,736 kb
 * 396 ms
 * 
 * * 풀이
 * 1. 회의실 문제처럼 풀었으나 더 생각해야 하는 게 많음 : 반례가 존재함
 * 2. 우선순위 큐를 2개 사용해서 풀었으나 디버깅에 실패
 * 3. 정렬 후 간선마다 그리디하게 처리
 * 
 * 정답 코드는 아주 간단하지만 로직을 생각하는 게 아주 어려웠음
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
	static int N, C, M, answer, weights[];
	static Edge[] arr;
	
	static class Edge{
		int from;
		int to;
		int w;
		
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(input.readLine());
		arr = new Edge[M];
		weights = new int[N+1]; // 각 마을에서 출발할 때 최대로 실을 수 있는 무게
		Arrays.fill(weights, C); 
		int idx = 0, maxBox, carry;
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			arr[idx++] = new Edge(from, to, weight);
		}
		// 도착지 오름차순, 같으면 출발지 내림차순으로 정렬
		Arrays.sort(arr, (o1, o2)->{
			if(o1.to==o2.to) {
				return Integer.compare(o2.from, o1.from);
			}
			return Integer.compare(o1.to, o2.to);
		});
		
		for(int i=0; i<arr.length; i++) {
			Edge d = arr[i]; // 출발지, 도착지, 택배 수
			maxBox = C; 
			// (출발지) ~ (도착지-1)에서 실을 수 있는 택배 수의 최솟값 
			// 한 군데에서도 지나가는 총 택배 수가 C를 초과할 순 없음
			for(int j=d.from; j<d.to; j++) {
				maxBox = Math.min(maxBox, weights[j]);
			}
			// 최대로 실을 수 있는 택배 수, 현재 실을 택배 수 중 더 작은 값
			carry = Math.min(maxBox, d.w);
			// (출발지) ~ (도착지-1)의 최대 택배 수에 현재 d에서 실을 택배 수만큼 뺌
			for(int j=d.from; j<d.to; j++) {
				weights[j]-=carry;
			}
			// 전체 배송할 택배 수에 더함
			answer+=carry;
		}
		output.append(answer);
		System.out.println(output.toString());
	}
}
