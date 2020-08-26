/**
 * 오목 - S3
 * 구현, 브루트포스
 * 13,052 kb
 * 80 ms
 * 
 * 주의해야할 경우
 * 6개의 돌 이상 줄을 중간부터 탐색하는 경우
 * -> 5개를 찾았을 경우 반대쪽에 같은 돌이 없는지 확인
 * -> 반대쪽 확인할 경우 배열을 벗어나도 괜찮음
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
	static int[][] arr;
	static int answer, cnt, answerR, answerC;
	static int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	static boolean[][] visited;
	
	static int checkFive(int color, int r, int c, int dir, int count) {
		if(count>5) return 6;
		while(true) {
			int nr = r+dirs[dir][0];
			int nc = c+dirs[dir][1];
			if(!(nr<=0 || nr>=arr.length || nc<=0 || nc>=arr.length) && arr[nr][nc]==color) {
				r = nr; c = nc;
				count++;
			}else {
				break;
			}
		}
		return count;
		
	}
	
	static void checkWin(int color, int r, int c, int count) {
		visited[r][c] = true;
		for(int i=0; i<dirs.length; i++) {
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			if(nr<=0 || nr>=arr.length || nc<=0 || nc>=arr.length) continue;
			if(arr[nr][nc]==color) {
				int tmp = checkFive(color, nr, nc, i, count+1);
				if(tmp==5) {
					int tmpR = r-dirs[i][0];
					int tmpC = c-dirs[i][1];
					if(tmpR>0 && tmpR<arr.length && tmpC>0 && tmpR<arr.length) {
						if(arr[tmpR][tmpC]!=color) {
							answer = color;							
						}
					}else {
						answer = color;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		arr = new int[20][20];
		visited = new boolean[20][20];
		answer = 0;
		for(int i=1; i<arr.length; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=1; j<arr.length; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		outerLoop: for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[j][i]==1 || arr[j][i]==2) {
					checkWin(arr[j][i], j, i, 1);
					if(answer!=0) {
						answerR = j;
						answerC = i;
						break outerLoop;
					}
				}
			}
		}
		System.out.println(answer);
		if(answer!=0) {
			System.out.println(answerR+" "+answerC);			
		}
	}
}
