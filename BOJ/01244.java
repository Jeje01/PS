/**
 * 스위치 켜고 끄기 - S4
 * 구현
 * 130,52 kb
 * 76 ms
 * 
 * 단순 구현 문제
 * 배열 참조 시 index 주의하기
 * 출력 형식 같은 조건 잊지 않게 미리 코드나 주석 작성하기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, sw[], stu;
	
	static void girl(int pos) {
		sw[pos] = 1-sw[pos];
		int i=1;
    // 대칭인 거리 세지 않고 바로 바꾸면 됨
		while(pos-i>0 && pos+i<=N) { 
			if(sw[pos-i]==sw[pos+i]) { 
				sw[pos-i] = sw[pos+i] = 1-sw[pos+i];
			}else {
				break;
			}
			i++;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		sw = new int[N+1];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=1; i<=N; i++) {
			sw[i] = Integer.parseInt(tokens.nextToken());
		}
		stu = Integer.parseInt(input.readLine());
		for(int t=1; t<=stu; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int sex = Integer.parseInt(tokens.nextToken());
			int num = Integer.parseInt(tokens.nextToken());
			switch(sex) {
			case 1:
				for(int i=num; i<=N; i+=num) {
					sw[i] = 1-sw[i];
				}
				break;
			case 2:
				girl(num);
				break;
			}
		}
		
		for(int i=1; i<sw.length; i++) {
			output.append(sw[i]);
			if(i%20==0) {
				output.append("\n");
			}else {
				output.append(" ");
			}
		}
		System.out.println(output.toString());
		
	}
}
