/**
 * 외판원 순회 2 - S2
 * 백트래킹, 외판원 순회
 * 13,448 kb
 * 88 ms
 * 
 * 순환하기 때문에 한 지점에서만 구하면 됨
 * 0->1->2->3->0 과 2->3->0->1->2는 같음 : 0에서만 구하면 됨
 * dp 사용 안 해도 통과함
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, W[][];
	static long min;
	
	static void getDis(int flag, int n, int total) {
		if(total>=min) return; 
		if(flag==(1<<N)-1) {
			if(W[n][0]!=0) {
				int tmp = total+W[n][0];
				min = Math.min(min, tmp);
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(W[n][i]==0 || (flag &1<<i)!=0) continue;
			getDis(flag|1<<i, i, total+W[n][i]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		W = new int[N][N];
        min = 987654321;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
        getDis(0 |(1<<0), 0, 0);

		output.append(min);
		System.out.println(output.toString());
		
	}
	
}
