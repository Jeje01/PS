/**
 * 창고 다각형 - S2
 * 브루트포스, 투 포인터
 * 19,720 kb
 * 228 ms
 * 
 * 양쪽에서 탐색해야됨
 * 중간에서 만나는 지점은 전체 중에 가장 높은 곳
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_02304_창고_다각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, arr[][], max, maxX;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
    
		Arrays.sort(arr, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});
		
    // 최댓값 구하기
    for(int i=0; i<N; i++) {
			if(arr[i][1]>max) {
				max = arr[i][1];
				maxX = i;
			}
		}
    
		int answer = 0, h = 0;
    
		// 왼쪽 ~ max
		for(int i=0; i<maxX; i++) {
			h = Math.max(arr[i][1], h);
			answer += (arr[i+1][0]-arr[i][0])*h;
		}
		h = 0;
		
    // max ~ 오른쪽
		for(int i=N-1; i>maxX; i--) {
			h = Math.max(arr[i][1], h);
			answer += (arr[i][0]-arr[i-1][0])*h;
		}
		
    // max
		answer += max;
		
		output.append(answer);
		System.out.println(output.toString());

	}
}
