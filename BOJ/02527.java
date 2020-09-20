/**
 * 직사각형 - S1
 * 기하학
 * 13,032 kb
 * 80 ms
 * 
 * * 풀이
 * 가로, 세로 각각 겹치는 점의 개수를 구해서 계산
 * 
 * * 주의
 * 가로, 세로 중 하나라도 겹치는 점이 0일 경우 두 직사각형은 만나지 않음
 * a==0 && b==0 이 아니라 a==0 || b==0 일 때 code = 'd' : 만나지 않음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int arr[], map[][];
	
	public static void main(String[] args) throws IOException {
		arr = new int[9];
		for(int t=1; t<=4; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int i=1; i<=8; i++) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			int a=0, b=0;
			

			if(arr[1]<arr[5]) { // A가 앞쪽에 있을 때
				if(arr[3]>=arr[5]) { // A 뒤와 B 앞이 겹칠 때 겹치는 선분 개수
					a = arr[3]-arr[5]+1;
				}
			}else if(arr[1]>arr[5]) {
				if(arr[7]>=arr[1]) {
					a = arr[7]-arr[1]+1;
				}
			}else {
				a = Math.min(arr[3], arr[7])-arr[1]+1;
			}
			if(arr[2]<arr[6]) {
				if(arr[4]>=arr[6]) {
					b = arr[4]-arr[6]+1;
				}
			}else if(arr[2]>arr[6]) {
				if(arr[8]>=arr[2]) {
					b = arr[8]-arr[2]+1;
				}
			}else {
				b = Math.min(arr[4], arr[8])-arr[2]+1;
			}
			char code;
			if(a==0 || b==0) {
				code = 'd';
			}else if(a==1 && b==1) {
				code = 'c';
			}else if(a==1 || b==1) {
				code = 'b';
			}else {
				code = 'a';
			}
			output.append(code).append("\n");
		}
		System.out.println(output.toString());
	}
}
