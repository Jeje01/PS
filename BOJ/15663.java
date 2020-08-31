/**
 * N과 M(9) - S2
 * 순열, 백트래킹
 * 19,688 kb
 * 148 ms
 * 
 * * 풀이
 * 중복을 제거해야 하기 때문에 처음에는 HashSet을 이용해서 풀었다.
 * 다른 사람의 풀이에서 visited를 원소의 개수로 두는 방법을 찾았다.
 * 
 * 여러 개 존재하는 원소의 경우 수열에 한 번 더 포함될 수 있다.
 * 순열 탐색 대상인 배열에서 중복되는 수가 없어 구조가 같은 수열은 나올 수 없다.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, idx;
	static int[] values, cnt;
	
	static void perm(int[] arr, int pos) {
		if(pos == M) {
			for(int a : arr) {
				output.append(a).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=0; i<idx; i++) {
			if(cnt[i]==0) continue;
			cnt[i]--;
			arr[pos] = values[i];
			perm(arr, pos+1);
			cnt[i]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		values = new int[N];
		cnt = new int[8];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<N; i++) {
			values[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(values);
		idx = 1;
    // 탐색 대상 순열에서 중복되는 수 제외해주고, 각 원소의 개수 저장
		for(int i=0; i<N; i++) {
			if(i==0 || values[i]==values[i-1]) {
				cnt[idx-1]++;				
			}else {
				values[idx] = values[i];
				cnt[idx++]++;
			}
		}
		// idx : 배열의 크기
		perm(new int[M], 0);
		System.out.println(output.toString());
		
	}
}
 
 
