/**
 * 직사각형을 만드는 방법 - B3
 * 구현
 * 12,908 kb
 * 136 ms
 * 
 * 단순한 수학 문제이지만 1부터 범위 내의 모든 숫자로 나누는 걸 2의 배수인 수만 나눈다고 착각해 WA를 많이 받았다.
 * 처음에 착각을 하게 되면 잘 안 보여서 뭐가 잘못됐는지 찾기가 힘들다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static long answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i=1; i<=N; i++) {
			int mod = 1;
			while(mod<=i) {
				if(i%mod==0) {
					if(mod>i/mod) {
						break;
					}else {
						answer++;
					}
				}
				mod++;
			}
			System.out.println(answer);
		}
		output.append(answer);
		System.out.println(output.toString());
		
	}
}
