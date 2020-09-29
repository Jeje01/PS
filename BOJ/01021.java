/**
 * 회전하는 큐 - S4
 * 자료구조, 덱
 * 13,044 kb
 * 88 ms
 * 
 * ArrayList를 사용해서 반대로 큐를 회전하는 경우,
 * 회전 연산은 동일하게 하고 답 값 계산만 다르게 함
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, answer=0;
	static List<Integer> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<M; i++) {
			int tmp = Integer.parseInt(tokens.nextToken());
			int idx = list.indexOf(tmp);
			if(idx==0) {
				list.remove(0);
			}else {
				if(idx<=list.size()-idx) {
					answer+=idx;
				}else {
					answer+=list.size()-idx;
				}
				for(int j=0; j<idx; j++) {
					list.add(list.remove(0));
				}
				list.remove(0);
			}
		}
		output.append(answer);
		System.out.println(output.toString());
		
	}
}
