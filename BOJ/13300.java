/**
 * 방 배정 - B2
 * 구현
 * 13,492 kb
 * 96 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int arr[][], N, K, sex, grade;
	
	public static void main(String[] args) throws IOException {
		arr = new int[7][2];
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			sex = Integer.parseInt(tokens.nextToken());
			grade = Integer.parseInt(tokens.nextToken());
			arr[grade][sex]++;
		}
		int cnt = 0;
		for(int i=1; i<7; i++) {
			for(int j=0; j<2; j++) {
				cnt+=arr[i][j]/K;
				if(arr[i][j]%K!=0) cnt++; 
			}
		}
		output.append(cnt);
		System.out.println(output.toString());
		
	}

}
