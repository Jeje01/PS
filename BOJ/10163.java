/**
 * 색종이 - B1
 * 구현
 * 13,280 kb
 * 92 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, map[][], arr[], cnt[];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[101][101];
		arr = new int[4];
		cnt = new int[N+1];
		for(int n=1; n<=N; n++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<4; j++) {
				arr[j] = Integer.parseInt(tokens.nextToken());
			}
			for(int i=arr[0]; i<arr[0]+arr[2]; i++) {
				for(int j=arr[1]; j<arr[1]+arr[3]; j++) {
					map[i][j] = n;
				}
			}
		}
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				cnt[map[i][j]]++;
			}
		}
		for(int i=1; i<=N; i++) {
			output.append(cnt[i]).append("\n");
		}
		System.out.println(output.toString());
	}
	
}
