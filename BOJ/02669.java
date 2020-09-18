/**
 * 직사각형 네개의 합집합의 면적 구하기 - B2
 * 구현
 * 12,976 kb
 * 84 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int arr[];
	static boolean map[][];
	
	public static void main(String[] args) throws IOException {
		arr = new int[4];
		map = new boolean[101][101];
		for(int i=0; i<4; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<4; j++) {
				arr[j] = Integer.parseInt(tokens.nextToken());
			}
			arr[0]++; arr[1]++;
			for(int j=arr[0]; j<=arr[2]; j++) {
				for(int k=arr[1]; k<=arr[3]; k++) {
					map[j][k]=true;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]) cnt++;
			}
		}
		output.append(cnt);
		System.out.println(output.toString());
	}
}
