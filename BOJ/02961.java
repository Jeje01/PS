/**
 * 도영이가 만든 맛있는 음식
 * 부분집합
 * 12,976 kb
 * 84 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static long[][] flavor;
	static long answer;
	static int N;

	public static void powerSet(int start, int end, boolean[] temp) {
		if(start==end) {
			long sour=1, bitter=0, count=0;
			for(int i=0; i<flavor.length; i++) {
				if(temp[i]) {
					sour*=flavor[i][0];
					bitter+=flavor[i][1];
					count++;
				}
			}
			if(count!=0) {
				answer = answer<Math.abs(sour-bitter)? answer:Math.abs(sour-bitter); 
			}
			return;
		}
		
		temp[start]=true;
		powerSet(start+1, end, temp);
		
		temp[start]=false;
		powerSet(start+1, end, temp);
		
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		answer = Integer.MAX_VALUE;
		flavor = new long[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2;j++) {
				flavor[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		boolean[] temp = new boolean[N];
		powerSet(0, N, temp);
        System.out.println(answer);		
	}

}
