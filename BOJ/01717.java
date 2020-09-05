/**
 * 집합의 표현 - G4
 * 서로소 집합
 * 53,252 kb
 * 404 ms
 * 
 * 서로소 집합을 이용한 문제
 * unionSet, findSet, makeSet
 * 재귀적으로 해당 원소의 root를 찾아주는 과정이 필요함
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, m, op, a, b, rep[];
	
	static int findSet(int x) {
		if(rep[x]==x) {
			return x;
		}
		rep[x] = findSet(rep[x]);
		return rep[x];
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		rep = new int[n+1];
		for(int i=1; i<n+1; i++) {
			rep[i] = i;
		}
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			op = Integer.parseInt(tokens.nextToken());
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			if(op==0) {			
				int repA = findSet(a);
				int repB = findSet(b);
				rep[Math.max(repA, repB)] = Math.min(repA, repB);
			}else {
				if(findSet(a)==findSet(b)) {
					output.append("YES").append("\n");
				}else {
					output.append("NO").append("\n");
				}
			}
		}
		System.out.println(output.toString());
	}
	
}
