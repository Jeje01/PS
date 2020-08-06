/**
 * 회의실 배정
 * Greedy
 * 490,40 kb
 * 644 ms
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
	static int N, lastIndex, answer;
	static int[][] rooms;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		rooms = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				rooms[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		Arrays.sort(rooms, (o1, o2)-> {
			if(o1[1]==o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
	
		for(int i=0; i<rooms.length; i++) {
			int start = rooms[i][0], end = rooms[i][1];
			if(i==0) {
				answer++;
				lastIndex = end;
			}else {
				if(start>=lastIndex) {
					answer++;
					lastIndex = end;
				}
			}
				
		}
		output.append(answer).append("\n");
		System.out.println(output.toString());
	}

}
