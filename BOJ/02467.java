/**
 * 용액 - G5
 * 이분 탐색, 투 포인터
 * 32,616 kb
 * 284 ms
 * 
 * * 풀이
 * 양 끝 값에서 시작해서 안으로 좁혀오며 합 비교
 * 
 * * 주의
 * 오타 주의..
 * 이분 탐색은 종료 조건 주의
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static StringTokenizer tokens;
	static int N, arr[], sum=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int l=0, r=N-1, one=0, two=0;
		while(l<r) {
			int a = arr[l], b = arr[r];
			if(Math.abs(a+b)<sum) {
				sum = Math.abs(a+b);
				one = a;
				two = b;		
			} // 여기서 else break 하면 틀림 -> 이 지점을 지난 후에 최소합이 있을 수도
			if(a+b>0) { // 합이 양수면 작아져야 하므로
				r--; // 오른쪽-1
			}else if(a+b<0) { // 합이 음수면 커져야 하므로
				l++; // 왼쪽+1
			}else {
				break;
			}
		}
		output.append(one).append(" ").append(two);
		System.out.println(output.toString());
	}
}
