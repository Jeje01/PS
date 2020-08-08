/**
 * 소가 길을 건너간 이유 4 - G2
 * Greedy
 * 57,300 kb
 * 3,328 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int C, N, answer;
	static int[] chickens;
	static ArrayList<int[]> cows = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		C = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		chickens = new int[C];
		for(int i=0; i<C; i++) {
			chickens[i] = Integer.parseInt(input.readLine());
		}
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int[] tmp = new int[2];
			for(int j=0; j<2; j++) {
				tmp[j] = Integer.parseInt(tokens.nextToken());
			}
			cows.add(tmp);			
		}
		
		Arrays.sort(chickens);
		
		for(int i=0; i<chickens.length; i++) {
			int tmp = chickens[i];
			for(int j=0; j<cows.size(); j++) {
				if(cows.get(j)[1]<tmp) {
					cows.remove(j);
				}
			}
			if(cows.size()==0)
				break;
			Collections.sort(cows, (o1, o2)->{
				if(o1[1]==o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			});
			

			int index=0;
			while(index<cows.size()) {
				if(cows.get(index)[0]<=tmp && cows.get(index)[1]>=tmp) {
					cows.remove(index);
					answer++;
					break;
				}else {
					index++;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
