/**
 * 램프 - G5
 * 브루트포스, HashMap
 * 13,152 kb
 * 80 ms
 * 
 * * 풀이
 * K는 1000까지이므로 K의 모든 경우를 수를 구할 순 없음
 * 스위치를 열마다 조작하므로 같은 결과를 갖게 되는 행은 조작 전 행도 같음
 * K만큼의 스위치 조작 후에 불이 켜지는 String마다 각각의 개수를 저장 후 최댓값 출력
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, K, answer;
	static String lines[];
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		lines = new String[N];
		for(int i=0; i<N; i++) {
			lines[i] = input.readLine();
		}
		K = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			// 0 개수 체크하기
			int cnt = 0, j;
			for(j=0; j<M; j++) {
				if(lines[i].charAt(j)=='0') {
					cnt++;
					if(cnt>K) break;
				}
			}
			if(j==M && (K-cnt)%2==0) {
				if(map.containsKey(lines[i])) {
					map.put(lines[i], map.get(lines[i])+1);
				}else {
					map.put(lines[i], 1);					
				}
			}
		}
		Collection<Integer> values = map.values();
		for(int a: values) {
			answer = Math.max(answer, a);
		}
		output.append(answer);
		System.out.println(output.toString());
		
	}

}
