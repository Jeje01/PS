/**
 * 점프 점프 - B1
 * 브루트포스
 * 12,932 kb
 * 84 ms
 * 
 * 각각 몇 번이나 뛰었는지는 세줄 필요 없음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder output = new StringBuilder(); // 출력
	static StringTokenizer tokens; 
	static int X, Y, H1, H2, answer; 
	
	public static void main(String[] args) throws IOException {
		// 입력 받음
		tokens = new StringTokenizer(input.readLine());
		X = Integer.parseInt(tokens.nextToken()); // 한 번에 뛰는 거리
		Y = Integer.parseInt(tokens.nextToken()); 
		H1 = Integer.parseInt(tokens.nextToken()); // 출발 위치
		H2 = Integer.parseInt(tokens.nextToken()); 
		
		// while문에서 둘이 만나지 않고 중단될 경우 출력될 -1
		answer = -1;
		
		// 이 이상 넘어갈 경우 break
		int aBreak = H1+10000;
		int bBreak = H2+10000;
		
		// 둘이 만날 때까지 계속 반복
		while(true) {
			// 둘의 위치가 같으면
			if(H1==H2) {
				answer = H1; // 현재 위치 정답에 넣고
				break; // while문 중단
			} 
			if(H1>H2) { // H1의 좌표가 더 클 경우
				H2+=Y; // H2를 한 번 점프시킴
				if(H2>=bBreak) break; // 범위를 넘어갔을 경우 -1 출력
			}else if(H1<H2) { // H2의 좌표가 더 클 경우
				H1+=X; // H1를 한 버 점프시킴
				if(H1>=aBreak) break; // 범위를 넘어갔을 경우 -1 출력
			}
		}
		System.out.println(answer); // 정답 출력
	}
}
