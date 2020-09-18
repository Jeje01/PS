/**
 * 참외밭 - S5
 * 수학, 기하학
 * 12,968 kb
 * 88 ms
 * 
 * 수학적인 사고 필요
 * 
 * * 주의
 * 마지막이랑 첫번째 변이 빼는 사각형의 변일수도 있음
 * 
 * * 다른 풀이
 * (모든 인접한 변끼리 곱한 것의 총합)-(가로 최대 길이*세로 최대 길이*2) = 구하고자 하는 넓이
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int K, maxA, maxB;
	static int[] next = {0, 3, 4, 2, 1};
	static int small[], arr[][]; // 0: 가로, 1: 세로

	
	public static void main(String[] args) throws IOException {
		small = new int[2];
		arr = new int[6][2];
		K = Integer.parseInt(input.readLine());
		for(int i=0; i<6; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
			if(arr[i][0]>=3) {
				maxB = Math.max(maxB, arr[i][1]);
			}else {
				maxA = Math.max(maxA, arr[i][1]);
			}
		}
		for(int i=0; i<6; i++) {
			if(next[arr[i][0]]==arr[(i+1)%6][0]) {
				small[0] = arr[i][1];
				small[1] = arr[(i+1)%6][1];
				break;
			}
		}
		int answer = maxA*maxB-small[0]*small[1];
		output.append(answer*K);
		System.out.println(output.toString());
	}
	
}
