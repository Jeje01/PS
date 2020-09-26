/**
 * 수 이어가기 - S5
 * 브루트포스
 * 12,960 kb
 * 80 ms
 * 
 * 어렵게 생각해서 이분탐색을 좀 변형해서 사용해야 하지 않을까 생각했지만
 * 브루트포스로 전부 탐색해보는 문제였다.
 * 
 * 숫자를 a-b로 뺄 때 위치를 바꾸는 걸 마지막에 swap해주면 계속 같은 연산을 하면 된다.
 * 
 * 최대 개수일 때 출력하는 배열을 계속 저장해서 답이 나오면 바로 출력할 수 있게 했지만,
 * 항상 배열을 저장하는 것보다 답이 나왔을 때 다시 계산하며 저장하는 것이 비용이 더 절약되며 효율적
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N, answer, idx, ansIdx;
    
	static void getCnt(int n) {
		int a = N;
		int b = n;
		idx = 2;
		while(true) {
			int tmp = a-b;
			if(tmp<0) {
				break;
			}
			a = b;
			b = tmp;
			idx++;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i=N; i>=0; i--) {
			getCnt(i);
			int tmp = idx;
			if(tmp>=answer) {
				answer = tmp;
				ansIdx = i;
			}else {
				output.append(answer).append("\n");
				break;
			}	
		}
		int a = N, b = ansIdx;
		output.append(a+" "+b+" ");
		while(true) {
			int tmp = a - b;
			if(tmp<0) break;
			output.append(tmp).append(" ");
			a = b;
			b = tmp;
		}
		
		System.out.println(output.toString());
		
	}
}
