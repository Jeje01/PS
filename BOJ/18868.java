/**
 * 멀티버스 1 - B1
 * 브루트포스, 조합
 * 13,332 kb
 * 96 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens; 
	static int M, N, answer; 
	static int[][] arr; 
	
	// 해당 쌍의 학급의 실력이 비슷한지 확인
	static void checkSame(int x, int y) {
		int[] a = arr[x];
		int[] b = arr[y];
		
		for(int i=0; i<a.length-1; i++) { 
			for(int j=i+1; j<a.length; j++) { 
				if(a[i]<a[j]) { 
					if(b[i]>=b[j]) { 
						return; 
					}
				}
				if(a[i]==a[j]) { 
					if(b[i]!=b[j]) { 
						return; 
					}
				}
				if(a[i]>a[j]) { 
					if(b[i]<=b[j]) { 
						return; 
					}
				}
			}
		}
		// 중간에 탐색이 중단되지 않고 끝까지 온 경우
		answer++; // 정답에 1 추가함
	}
	
	// 한 쌍을 뽑는 조합
	static void makeCombination(int[] group, int idx, int start) {
		if(idx==2) { // 조합의 2개 원소를 다 뽑았을 경우
			checkSame(group[0], group[1]); 
			return; // 확인 후 종료
		}
		for(int i=start; i<M; i++) { // 앞부터 조합 탐색
			group[idx] = i; // arr에서 인덱스를 넣어줌
			makeCombination(group, idx+1, i+1); // 다음 원소를 넣어주는 조합 호출
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 문자열 입력 받음
		tokens = new StringTokenizer(input.readLine(), " ");
		M = Integer.parseInt(tokens.nextToken()); 
		N = Integer.parseInt(tokens.nextToken()); 
		arr = new int[M][N]; 
		for(int i=0; i<M; i++) { 
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<N; j++) { 
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		// M개의 반 중 두 개의 반을 뽑는 조합 
		makeCombination(new int[2], 0, 0); // 한 쌍의 인덱스, 조합 배열의 인덱스, 배열에서 조합 탐색을 시작할 위치
		System.out.println(answer); // 정답 출력
	}

}
