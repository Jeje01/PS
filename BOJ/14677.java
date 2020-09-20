/**
 * 병약한 윤호 - G5
 * DFS, DP, 투 포인터
 * 15,400 kb
 * 96 ms
 * 
 * * 풀이
 * 전형적인 DP 문제를 풀고 싶어 풀었지만 dfs로 푼 문제
 * 처음과 끝 모두에 다음 찾는 문자가 있을 경우, 양쪽을 dfs로 전부 탐색함
 * 후에 중복해서 탐색하게 됨 : 탐색하는 left, right이 같을 경우 visited가 true -> 탐색 중단
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
	static char[] line;
	static char[] order = {'B', 'L', 'D'};
	static boolean[][] visited;
	
	static void dfs(int start, int end, int o, int cnt) {
		if(answer==line.length || visited[start][end]) return;
		visited[start][end] = true;
		if(start>end) {
			answer = Math.max(answer, cnt);
			return;
		}
		char s = line[start], e = line[end];
		if(s!=order[o] && e!=order[o]) {
			answer = Math.max(answer, cnt);
			return;
		}
		if(s==order[o]) {
			dfs(start+1, end, (o+1)%3, cnt+1);
		}
		if(e==order[o]) {
			dfs(start, end-1, (o+1)%3, cnt+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine())*3;
		visited = new boolean[N+1][N+1];
		line = input.readLine().toCharArray();
		dfs(0, N-1, 0, 0);
		output.append(answer);
		System.out.println(output.toString());
	}
}
