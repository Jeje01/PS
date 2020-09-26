/**
 * 자리배정 - S5
 * 구현, 달팽이
 * 14,000 kb
 * 100 ms
 * 
 * 풀 때마다 헷갈리는 달팽이 문제
 * 
 * * 다른 풀이
 * 각 변마다 for문을 돌리면 break outerLoop를 써야하지만
 * 현재의 방향을 상태로 0~3 저장해두면 매번 상태마다 연산하면 됨
 * 
 * * 틀렸던 이유
 * aC, aR가 바뀌었음 -> 풀기 전에 테스트케이스 여러 개 확인해보기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int C, R, K, aR, aC;
	
	static void getLoc() {
		aC=1; aR=1;
        if(C==1 && R==1) {
			return;
		}
		int cur=0, row, col;
		row = R-1;
		col = C-1;
		outerLoop: while(cur<K) {
			for(int i=1; i<=row; i++) {
				cur++;
				if(cur==K) break outerLoop;
				aR++;
			}
			for(int i=1; i<=col; i++) {
				cur++;
				if(cur==K) break outerLoop;
				aC++;
			}
			for(int i=1; i<=row; i++) {
				cur++;
				if(cur==K) break outerLoop;
				aR--;
			}
			for(int i=1; i<=col; i++) {
				cur++;
				if(cur==K) break outerLoop;
				aC--;
			}
			aR++; aC++;
			row-=2;
			col-=2;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		 tokens = new StringTokenizer(input.readLine(), " ");
		 C = Integer.parseInt(tokens.nextToken());
		 R = Integer.parseInt(tokens.nextToken());
		 K = Integer.parseInt(input.readLine());
		 if(K>R*C) {
			 output.append(0);
		 }else {
			 getLoc();
			 output.append(aC+" "+aR);
		 }
		 System.out.println(output.toString());
		 
	}
}

