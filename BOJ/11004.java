/**
 * K번째 수
 * 정렬, 입출력
 * 684,908 kb
 * 3,756 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(tokens.nextToken()));	
		}
		Collections.sort(list);
		output.append(list.get(K-1)).append("\n");
		System.out.println(output.toString());
	}

}
