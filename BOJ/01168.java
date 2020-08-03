/**
 * 요세푸스 문제 2
 * 시뮬레이션, ArrayList
 * 26,032 kb
 * 984 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] answer;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		answer = new int[N];
		int index = 0;
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		int pos = K-1;
		while(list.size()!=0) {
			answer[index++] = list.remove(pos);
			pos+=K-1;
			if(list.size()!=0)
				pos%=list.size();
		}
		for(int i=0; i<N; i++) {
			if(i==0)
				output.append("<");
			output.append(answer[i]);
			if(i==N-1)
				output.append(">\n");
			else
				output.append(", ");
			
		}
		input.close();
		System.out.println(output.toString());
	}

}
